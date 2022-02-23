package pkpd.restaurant.dao;

import pkpd.restaurant.entity.SysRole;
import pkpd.restaurant.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;


@Mapper
public interface SysRoleDao extends tk.mybatis.mapper.common.Mapper<SysRole>{
    Set<String> findRoleNamesByUser(SysUser sysUser);
    List<SysRole> findAll();
}

