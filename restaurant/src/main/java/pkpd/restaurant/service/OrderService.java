package pkpd.restaurant.service;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Order;

/**
 * Created with IDEA
 * author:LiuJing
 * Date:2018/10/2
 * Time:15:02
 *
 * 
 */

public interface OrderService {
    /**
     * 
     * @param order
     */
    String addOrder(Order order);

    /**
     * 
     * @param customPageInfo
     * @return
     */
    CustomPageInfo<Order> findPage(CustomPageInfo<Order> customPageInfo);

    /**
     * id
     * @param orderId
     * @return
     */
    Order findById(Long orderId);

    /**
     * id
     * @param strIds
     */
    void deleteByIds(String strIds);

    /**
     * 
     * @param order
     */
    void update(Order order);

    /**
     * 
     * @param order
     */
    void settleAccounts(Order order);
}
