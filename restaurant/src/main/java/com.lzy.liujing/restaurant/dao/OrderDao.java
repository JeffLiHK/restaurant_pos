package com.lzy.liujing.restaurant.dao;

import com.lzy.liujing.restaurant.entity.CustomPageInfo;
import com.lzy.liujing.restaurant.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderDao{
    int insert(Order order);
    List<Order> findPage(CustomPageInfo<Order> pageInfo);
    Order findById(Long orderId);
    int deleteByIds(List<Long> idList);
    int update(Order order);
    int updateByOrderCode(Order order);
}
