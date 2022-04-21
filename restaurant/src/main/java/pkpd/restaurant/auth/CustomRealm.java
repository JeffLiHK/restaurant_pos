package pkpd.restaurant.auth;

import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.entity.SysMenu;
import pkpd.restaurant.entity.SysUser;
import pkpd.restaurant.exception.CustomAuthenticationException;
import pkpd.restaurant.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 
     * 
     * @param authenticationToken
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String loginCode = (String) token.getPrincipal();
       //username loginCode
        SysUser user = sysUserService.findByLoginCode(loginCode);
        if(user==null){
            //AuthenticationException
            throw new CustomAuthenticationException(ResultEnum.USER_NO_FOUND);
        }else if(!user.getPassword().equals(new String((char[]) token.getCredentials()))){
            throw new CustomAuthenticationException(ResultEnum.PWD_ERROR);
        }
        // ，session
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user",user);
        //
        return new SimpleAuthenticationInfo(
                user,//
                user.getPassword(),//
                ByteSource.Util.bytes(loginCode),
                getName()//realm name
        );
    }

    /**
     * 
     * 
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //.
        String loginCode = ((SysUser) SecurityUtils.getSubject().getPrincipal()).getLoginCode();
        //
        SysUser param = sysUserService.findByLoginCode(loginCode);
        //info,（role）（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = sysUserService.findRoleNameByUser(param);
        info.setRoles(roles);
        SysMenu sysMenu = new SysMenu();
        sysMenu.getCondition().put("list",roles);
        //According to the role information, query the permission string possessed by the user
        List<SysMenu> menuList = sysUserService.findMenuList(sysMenu);
        Set<String> permissions = new HashSet<>();
        for(SysMenu menu:menuList){
            if(!StringUtils.isEmpty(menu.getPermission())){
                permissions.add(menu.getPermission());
                System.out.println(menu.getPermission());
            }
        }
        // give the permission name to info
        // There will be no duplicate data in the set collection
        info.setStringPermissions(permissions);
        return info;
    }
}
