package com.lzy.liujing.restaurant.dao;

import com.lzy.liujing.restaurant.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface GoodsDao extends tk.mybatis.mapper.common.Mapper<Goods>{
    List<Goods> findPage(Goods goods);
    Goods findById(Integer goodsId);
    Goods findByGoodsName(Goods goods);
    List<Goods> findByGoodsIds(List<Integer> goodsIdList);
    int insert(Goods goods);
    int update(Goods goods);
    int deleteByIds(List<Integer> idList);
}
