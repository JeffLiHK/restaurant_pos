package pkpd.restaurant.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.dao.DeskDao;
import pkpd.restaurant.dao.OrderDao;
import pkpd.restaurant.dao.OrderDetailDao;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Desk;
import pkpd.restaurant.entity.Order;
import pkpd.restaurant.entity.OrderDetail;
import pkpd.restaurant.exception.CustomException;
import pkpd.restaurant.service.CookAndServingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 
 */
@Service
@Transactional
public class CookAndServingServiceImpl implements CookAndServingService {
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private DeskDao deskDao;

    /**
     * 
     * @param pageInfo
     * @return
     */
    @Override
    public List<OrderDetail> cookTaskFindPage(CustomPageInfo<OrderDetail> pageInfo) {
        List<Integer> statusList = new ArrayList<>();
        //
        statusList.add(1);
        List<OrderDetail> resultCookTaskList = orderDetailDao.findPageByStatus(statusList);
        //id
        cookTaskManage(resultCookTaskList);
        //
        statusList.clear();
        statusList.add(0);
        List<OrderDetail> cookingTaskList = orderDetailDao.findPageByStatus(statusList);
        //id
        cookTaskManage(cookingTaskList);
        //
        resultCookTaskList.addAll(cookingTaskList);
        return resultCookTaskList;
    }

    /**
     * ，id
     * @param cookList
     */
    @Override
    public void cookTaskManage(List<OrderDetail> cookList) {
        //
        Map<Integer, OrderDetail> map = new LinkedHashMap<>();
        for (OrderDetail detail : cookList){
            Integer key = detail.getGoods().getGoodsId();
            //
            if (map.containsKey(key)) {
                OrderDetail od = map.get(key);
                //idid
                od.getOdIdList().add(detail.getOdId());
                //
                od.setCount(od.getCount()+detail.getCount());
                map.put(key, od);
            } else {
                //，id
                detail.setOdIdList(new ArrayList<>());
                //idid
                detail.getOdIdList().add(detail.getOdId());
                map.put(key, detail);
            }
        }
        //
        cookList.clear();
        //
        cookList.addAll(map.values());
    }

    /**
     * odId,id
     * @param orderDetail
     */
    @Override
    public void updateStatusByOdIds(OrderDetail orderDetail){
       int effect = orderDetailDao.updateStatusByOdIds(orderDetail);
       if(effect<=0){
           throw new CustomException(ResultEnum.UPDATE_DB_FAIL);
       }
    }

    /**
     * 
     *
     * @param pageInfo
     * @return
     */
    @Override
    public CustomPageInfo<OrderDetail> servingTaskFindPage(CustomPageInfo<OrderDetail> pageInfo) {
        Page page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<Integer> statusList = new ArrayList<>();
        statusList.add(2);
        orderDetailDao.findPageByStatus(statusList);
        CustomPageInfo<OrderDetail> resultInfo = new CustomPageInfo<>(page);
        return resultInfo;
    }

    /**
     * 
     *
     * @param orderDetail
     */
    public void finishServing(OrderDetail orderDetail) {
        //3
        orderDetail.setStatus(3);
        orderDetailDao.update(orderDetail);
        //
        OrderDetail query = new OrderDetail();
        query.setOrder(orderDetail.getOrder());
        List<OrderDetail> queryOrderDetailList = orderDetailDao.findPage(query);
        int count = 0;
        for (OrderDetail queryOrderDetail : queryOrderDetailList) {
            if (queryOrderDetail.getStatus() == 3) {
                count++;
            }
        }
        /**
         * 
         * 
         */
        if (count == queryOrderDetailList.size()){
            Order order = orderDetail.getOrder();
            order.setFinishStatus(1);
            /**
             * ，
             */
            if(queryOrderDetailList.get(0).getOrder().getPayStatus()==1){
                order.setOverStatus(1);
                //''
                String currDeskCode = queryOrderDetailList.get(0).getOrder().getDeskCode();
                Desk desk = new Desk();
                desk.setDeskCode(currDeskCode);
                desk.setIdleStatus(2);
                deskDao.update(desk);
            }
            orderDao.update(order);
        }
    }
}
