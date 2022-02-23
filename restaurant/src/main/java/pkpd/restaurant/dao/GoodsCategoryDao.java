package pkpd.restaurant.dao;

import pkpd.restaurant.entity.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * Created with IDEA
 * author:LiuJing
 * Date:2018/10/1
 * Time:23:36
 */
@Mapper
public interface GoodsCategoryDao extends tk.mybatis.mapper.common.Mapper<GoodsCategory>{
    List<GoodsCategory> findAll();
    GoodsCategory findById(Long id);
    int insert(GoodsCategory goodsCategory);
    int update(GoodsCategory goodsCategory);
    int deleteByIds(List<Long> idList);
    GoodsCategory findByCategoryName(GoodsCategory goodsCategory);
}
