package pkpd.restaurant.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.dao.SysMenuDao;
import pkpd.restaurant.dao.SysRoleDao;
import pkpd.restaurant.dao.SysUserDao;
import pkpd.restaurant.dao.UserRoleDao;
import pkpd.restaurant.entity.*;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.SysMenu;
import pkpd.restaurant.entity.SysRole;
import pkpd.restaurant.entity.SysUser;
import pkpd.restaurant.entity.UserRole;
import pkpd.restaurant.entity.request.UserRequest;
import pkpd.restaurant.exception.CustomException;
import pkpd.restaurant.service.SysUserService;
import pkpd.restaurant.utils.MenuUtil;
import pkpd.restaurant.utils.SplitIdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private UserRoleDao userRoleDao;

    /**
     * 
     *
     * @param loginCode
     * @return
     */
    @Override
    public SysUser findByLoginCode(String loginCode) {
        return sysUserDao.findByLoginCode(loginCode);
    }

    /**
     * 
     *
     * @param sysMenu
     * @return
     */
    @Override
    public List<SysMenu> findMenuList(SysMenu sysMenu) {
        return sysMenuDao.findList(sysMenu);
    }

    /**
     * 
     *
     * @param sysUser
     * @return
     */
    public Set<String> findRoleNameByUser(SysUser sysUser) {
        return sysRoleDao.findRoleNamesByUser(sysUser);
    }

    /**
     * 
     *
     * @param sysUser
     * @return
     */
    @Override
    public List<SysMenu> findMenuTreeByUser(SysUser sysUser) {
        Set<String> roles = sysRoleDao.findRoleNamesByUser(sysUser);
        SysMenu sysMenu = new SysMenu();
        sysMenu.getCondition().put("list", roles);
        //，
        //
        List<SysMenu> formatMenuList = MenuUtil.formatMenuList(sysMenuDao.findList(sysMenu), false);
        return formatMenuList;
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.selectAll();
    }

    /**
     * 
     * @param sysUser
     */
    @Override
    public void update(SysUser sysUser) throws CustomException {
        SysUser findUser = sysUserDao.searchPhone(sysUser);
        if(findUser!=null){
            throw new CustomException(ResultEnum.PHONE_IS_EXIST);
        }
        findUser = sysUserDao.findByIdNumber(sysUser);
        if(findUser!=null){
            throw new CustomException(ResultEnum.ID_NUMBER_IS_EXIST);
        }
        sysUser.setModifyTime(new Date());
        sysUserDao.update(sysUser);
        UserRole userRole = new UserRole();
        userRole.setUserId(sysUser.getUserId());
        userRole.setRoleId(sysUser.getRole().getRoleId());
        if(sysUser.getRole().getRoleId()!=null){
            userRoleDao.update(userRole);
        }
    }

    /**
     * 
     * @param sysUser
     */
    @Override
    public void addUser(SysUser sysUser) throws CustomException{
        SysUser findUser = sysUserDao.searchLoginCode(sysUser.getLoginCode());
        if (findUser != null) {
            //code 101 msg 
            throw new CustomException(ResultEnum.USER_IS_EXIST);
        }
        //
        findUser = sysUserDao.searchPhone(sysUser);
        if(findUser!=null){
            throw new CustomException(ResultEnum.PHONE_IS_EXIST);
        }
        findUser = sysUserDao.findByIdNumber(sysUser);
        if (findUser != null) {
            //code 101 msg 
            throw new CustomException(ResultEnum.ID_NUMBER_IS_EXIST);
        }
        sysUser.setCreateTime(new Date());
        //
        sysUser.setPassword("123456");
        try {
            sysUser.setModifyTime(new Date());
            sysUserDao.insert(sysUser);
            UserRole userRole = new UserRole();
            userRole.setUserId(sysUser.getUserId());
            userRole.setRoleId(sysUser.getRole().getRoleId());
            userRoleDao.insert(userRole);
        } catch (Exception e) {
            throw new CustomException(ResultEnum.INSERT_DB_FAIL);
        }
    }

    /**
     * 
     * @param userRequest
     * @return
     */
    @Override
    public CustomPageInfo<SysUser> findPage(UserRequest userRequest) {
        //PageHelper
        Page page = PageHelper.startPage(userRequest.getPageNum(), userRequest.getPageSize());
        /**
         * ,page，pagehelper()
         */
        sysUserDao.findPage(userRequest);
        //,
        CustomPageInfo<SysUser> resultPageInfo = new CustomPageInfo<>(page);
        return resultPageInfo;
    }

    /**
     * 
     *
     * @return
     */
    @Override
    public List<SysRole> findRoleList() {
        return sysRoleDao.findAll();
    }

    /**
     * id
     */
    @Override
    public void deleteByIds(String strIds) throws CustomException{
        List<Long> idList = SplitIdsUtil.splitStrIds(strIds);
        int effectNum = sysUserDao.deleteByIds(idList);
        if(effectNum<0){
            // code 101 msg ""
            throw new CustomException(ResultEnum.DEL_DB_FAIL);
        }
    }
    /**
     * id
     * @return
     */
    @Override
    public SysUser findById(Long id) {
        return sysUserDao.findById(id);
    }

    /**
     * 
     * @param sysUser
     */
    public void resetPwd(SysUser sysUser){
        sysUserDao.update(sysUser);
    }

    /**
     * 
     * @param sysUser
     */
    @Override
    public void updatePwd(SysUser sysUser) {
       SysUser findUser = sysUserDao.findById(sysUser.getUserId());
       if(!findUser.getPassword().equals(sysUser.getOldPwd())){
           throw  new CustomException(ResultEnum.PWD_ERROR);
       }
       SysUser user = new SysUser();
       user.setUserId(sysUser.getUserId());
       user.setPassword(sysUser.getNewPwd());
       sysUserDao.update(user);
    }
}
