package pkpd.restaurant.service;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.SysMenu;
import pkpd.restaurant.entity.SysRole;
import pkpd.restaurant.entity.SysUser;
import pkpd.restaurant.entity.request.UserRequest;

import java.util.List;
import java.util.Set;

/**
 * 
 */
public interface SysUserService {

    /**
     * 
     * @param loginCode
     * @return
     */
    SysUser findByLoginCode(String loginCode);

    /**
     * 
     * @param sysMenu
     * @return
     */
    List<SysMenu> findMenuList(SysMenu sysMenu);

    /**
     * 
     * @param sysUser
     * @return
     */
    Set<String> findRoleNameByUser(SysUser sysUser);

    /**
     * 
     * @param sysUser
     * @return
     */
    List<SysMenu> findMenuTreeByUser(SysUser sysUser);
    /**
     * 
     */
    List<SysUser> findAll();
    /**
     * 
     * @param sysUser
     * @return
     */
    void update(SysUser sysUser);

    /**
     * 
     * @param sysUser
     * @return
     */
    void addUser(SysUser sysUser);

    /**
     * ，
     * @param userRequest
     * @return
     */
    CustomPageInfo<SysUser> findPage(UserRequest userRequest);

    /**
     * 
     * @return
     */
    List<SysRole> findRoleList();

    /**
     *id
     */
    void deleteByIds(String ids);

    /**
     * id
     * @return
     */
    SysUser findById(Long id);
    void resetPwd(SysUser sysUser);
    void updatePwd(SysUser sysUser);
}
