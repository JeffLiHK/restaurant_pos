package pkpd.restaurant.service;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.OrderDetail;

import java.util.List;

/**
 * 
 */
public interface OrderDetailService {
    /**
     * id
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(Long orderId);

    /**
     * 
     * @param pageInfo
     * @return
     */
    CustomPageInfo<OrderDetail> findPage(CustomPageInfo<OrderDetail>  pageInfo);

    /**
     * id
     * @param strIds
     */
    void deleteByIds(String strIds);
    List<OrderDetail> findOrderDetailsByDeskCode(String deskCode);
}
