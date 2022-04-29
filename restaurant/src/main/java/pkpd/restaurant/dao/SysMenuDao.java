package pkpd.restaurant.dao;

import pkpd.restaurant.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IDEA
 * author:Jeff Li
 * Date:2020/10/1
 * Time:23:31
 */
@Mapper
public interface SysMenuDao extends tk.mybatis.mapper.common.Mapper<SysMenu>{
    SysMenu findById(Long menuId);

    /**
     *
     * @param sysMenu
     * @return
     */
    List<SysMenu> findList(SysMenu sysMenu);
}
