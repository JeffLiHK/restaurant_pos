package pkpd.restaurant.dao;

import pkpd.restaurant.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IDEA
 * author:Jeff Li
 * Date:2020/10/1
 * Time:23:36
 */
@Mapper
public interface OrderDetailDao{
    List<OrderDetail> findPage(OrderDetail orderDetail);
    List<OrderDetail> findPageByStatus(List<Integer> statusList);
    List<OrderDetail> findOderDetailByOdIds(List<Long> odIdList);
    int insert(List<OrderDetail> detailList);
    int deleteByIds(List<Long> odIdList);
    int deleteByOrderIds(List<Long> orderIdList);
    int update(OrderDetail orderDetail);
    int updateStatusByOdIds(OrderDetail orderDetail);
    Double countPriceByOdIds(List<Long> odIds);
}
