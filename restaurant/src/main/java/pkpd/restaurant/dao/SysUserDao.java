package pkpd.restaurant.dao;

import pkpd.restaurant.entity.SysUser;
import pkpd.restaurant.entity.request.UserRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserDao extends tk.mybatis.mapper.common.Mapper<SysUser>{
    /**
     *
     * @return
     */
    List<SysUser> findPage(UserRequest userRequest);

    /**
     *
     * @return
     */
    SysUser findByLoginCode(String loginCode);
    /**
     * id
     * @return
     */
    SysUser findById(Long id);

    /**
     *
     * @param loginCode
     * @return
     */
    SysUser searchLoginCode(String loginCode);

    SysUser searchPhone(SysUser sysUser);

    SysUser findByIdNumber(SysUser idNumber);

    /**
     *
     * @param sysUser
     * @return
     */
    int update(SysUser sysUser);

    /**
     *
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * id
     * @param ids
     * @return
     */
    int deleteByIds(List<Long> ids);
}
