package pkpd.restaurant.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.dao.OrderDao;
import pkpd.restaurant.dao.OrderDetailDao;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Order;
import pkpd.restaurant.entity.OrderDetail;
import pkpd.restaurant.exception.CustomException;
import pkpd.restaurant.service.OrderDetailService;
import pkpd.restaurant.utils.SplitIdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 
 */
@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderDao orderDao;

    /**
     * id
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderDetail> findByOrderId(Long orderId) {
        OrderDetail orderDetail = new OrderDetail();
        Order order = new Order();
        order.setOrderId(orderId);
        orderDetail.setOrder(order);
        return orderDetailDao.findPage(orderDetail);
    }

    /**
     * 
     *
     * @param pageInfo
     * @return
     */
    @Override
    public CustomPageInfo<OrderDetail> findPage(CustomPageInfo<OrderDetail> pageInfo) {
        Page page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        orderDetailDao.findPage(pageInfo.getT());
        CustomPageInfo<OrderDetail> resultInfo = new CustomPageInfo<>(page);
        return resultInfo;
    }

    /**
     * id
     *
     * @param strIds
     */
    @Override
    public void deleteByIds(String strIds) {
        List<Long> idList = SplitIdsUtil.splitStrIds(strIds);
        //
        Double minusPrice = orderDetailDao.countPriceByOdIds(idList);
        OrderDetail orderDetail = new OrderDetail();
        //id
        orderDetail.setOdId(idList.get(0));
        //id
        List<OrderDetail> orderDetailList = orderDetailDao.findPage(orderDetail);
        Long orderId = orderDetailList.get(0).getOrder().getOrderId();
        //
        Order findOrder = orderDao.findById(orderId);
        /**
         * 
         */
        Order updateOrder = new Order();
        updateOrder.setOrderId(findOrder.getOrderId());
        updateOrder.setTotalPrice(findOrder.getTotalPrice() - minusPrice);
        updateOrder.setModifyTime(new Date());
        orderDao.update(updateOrder);
        //
        int effect = orderDetailDao.deleteByIds(idList);
        if (effect <= 0) {
            throw new CustomException(ResultEnum.DEL_DB_FAIL);
        }
    }

    /**
     * 
     * @param deskCode
     * @return
     */
    @Override
    public List<OrderDetail> findOrderDetailsByDeskCode(String deskCode) {
        OrderDetail orderDetail = new OrderDetail();
        Order order = new Order();
        //
        order.setDeskCode(deskCode);
        //
        order.setPayStatus(0);
        orderDetail.setOrder(order);
        List<OrderDetail> resultList = orderDetailDao.findPage(orderDetail);
        return resultList;
    }
}
