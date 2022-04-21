package pkpd.restaurant.service;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.OrderDetail;

import java.util.List;

/**
 * Created with IDEA
 * author:LiuJing
 * Date:2018/10/2
 * Time:15:08
 *
 * 
 */

public interface CookAndServingService {
    /**
     * 
     * @param pageInfo
     * @return
     */
    List<OrderDetail> cookTaskFindPage(CustomPageInfo<OrderDetail> pageInfo);
    /**
     * 
     * @param pageInfo
     * @return
     */
    CustomPageInfo<OrderDetail> servingTaskFindPage(CustomPageInfo<OrderDetail> pageInfo);

    /**
     * 
     * @param orderDetail
     */
    void finishServing(OrderDetail orderDetail);

    /**
     * ，id
     * @param cookList
     */
    void cookTaskManage(List<OrderDetail> cookList);

    /**
     * odId,id
     * @param orderDetail
     */
    void updateStatusByOdIds(OrderDetail orderDetail);
}
