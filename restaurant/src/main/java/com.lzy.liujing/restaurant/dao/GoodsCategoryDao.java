package com.lzy.liujing.restaurant.dao;

import com.lzy.liujing.restaurant.entity.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface GoodsCategoryDao extends tk.mybatis.mapper.common.Mapper<GoodsCategory>{
    List<GoodsCategory> findAll();
    GoodsCategory findById(Long id);
    int insert(GoodsCategory goodsCategory);
    int update(GoodsCategory goodsCategory);
    int deleteByIds(List<Long> idList);
    GoodsCategory findByCategoryName(GoodsCategory goodsCategory);
}
