package pkpd.restaurant.dao;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IDEA
 * author:LiuJing
 * Date:2018/10/1
 * Time:23:36
 */
@Mapper
public interface OrderDao{
    int insert(Order order);
    List<Order> findPage(CustomPageInfo<Order> pageInfo);
    Order findById(Long orderId);
    int deleteByIds(List<Long> idList);
    int update(Order order);
    int updateByOrderCode(Order order);
}
