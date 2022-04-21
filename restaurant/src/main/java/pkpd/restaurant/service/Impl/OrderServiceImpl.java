package pkpd.restaurant.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.dao.*;
import pkpd.restaurant.entity.*;
import pkpd.restaurant.dao.*;
import pkpd.restaurant.entity.*;
import pkpd.restaurant.exception.CustomException;
import pkpd.restaurant.service.OrderService;
import pkpd.restaurant.utils.OrderCodeUtil;
import pkpd.restaurant.utils.SplitIdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberCategoryDao memberCategoryDao;
    @Autowired
    private DeskDao deskDao;
    /**
     * 
     *
     * @param order
     */
    @Override
    public String addOrder(Order order) {
        String orderCode = OrderCodeUtil.createOrderCode();
        //
        order.setOrderCode(orderCode);
        order.setCreateTime(new Date());
        //orderIdorder
        orderDao.insert(order);
        //orderId
        Order order1 = new Order();
        order1.setOrderId(order.getOrderId());
        //
        for (int i = 0; i < order.getOrderDetails().size(); i++) {
            order.getOrderDetails().get(i).setOrder(order1);
        }
        int effect = orderDetailDao.insert(order.getOrderDetails());
        //,
        for (OrderDetail detail:order.getOrderDetails()){
            updateStoreAndSold(detail.getGoods().getGoodsId(),detail.getCount());
        }
        if(effect<=0){
            throw new CustomException(ResultEnum.ADD_ORDER_FAIL);
        }
        return orderCode;
    }

    /**
     * 
     * @param goodsId
     * @param count
     */
    public void updateStoreAndSold(Integer goodsId,int count){
        Goods oldGoods = goodsDao.findById(goodsId);
        Goods newGoods = new Goods();
        newGoods.setGoodsId(oldGoods.getGoodsId());
        newGoods.setStoreCount(oldGoods.getStoreCount()-count);
        newGoods.setSoldCount(oldGoods.getSoldCount()+count);
        //0，
        if(oldGoods.getStoreCount()==count){
            newGoods.setSoldState(1);
        }
        goodsDao.update(newGoods);
    }
    /**
     * 
     * @param pageInfo
     * @return
     */
    @Override
    public CustomPageInfo<Order> findPage(CustomPageInfo<Order> pageInfo) {
        Page page = PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        orderDao.findPage(pageInfo);
        CustomPageInfo<Order> resultInfo = new CustomPageInfo<>(page);
        return resultInfo;
    }

    /**
     * id
     *
     * @param orderId
     * @return
     */
    @Override
    public Order findById(Long orderId){
        return orderDao.findById(orderId);
    }

    /**
     * id
     *
     * @param strIds
     */
    @Override
    public void deleteByIds(String strIds) {
       List<Long> idList =  SplitIdsUtil.splitStrIds(strIds);
       int effect = orderDao.deleteByIds(idList);
       if(effect<=0){
           throw new CustomException(ResultEnum.DEL_DB_FAIL);
       }
       orderDetailDao.deleteByOrderIds(idList);
    }

    /**
     * 
     *
     * @param order
     */
    @Override
    public void update(Order order){
        orderDao.update(order);
    }

    /**
     * 
     * @param order
     */
    @Override
    public void settleAccounts(Order order){
        OrderDetail orderDetail = new OrderDetail();
        Order conditionOrder = new Order();
        conditionOrder.setOrderCode(order.getOrderCode());
        orderDetail.setOrder(conditionOrder);
        List<OrderDetail> resultDetailList = orderDetailDao.findPage(orderDetail);
        //
        double totalCost=0;
        //
        for(OrderDetail detail:resultDetailList){
            //
            totalCost+=detail.getGoods().getCost()*detail.getCount();
        }
        //
        order.setTotalProfit(order.getMustPay()-totalCost);
        //
        order.setTotalCost(totalCost);
        //
        order.setPayStatus(1);
        /**
         * ，，1
         */
        if(resultDetailList.get(0).getOrder().getFinishStatus()==1){
            order.setOverStatus(1);
            //''
            String currDeskCode = resultDetailList.get(0).getOrder().getDeskCode();
            Desk desk = new Desk();
            desk.setDeskCode(currDeskCode);
            desk.setIdleStatus(0);
            deskDao.update(desk);
        }
        int effect = orderDao.updateByOrderCode(order);
        /**
         *  
         *  1
         *  2
         */
        Member member = order.getMember();
        //
        Member queryMember = (memberDao.findPage(member)).get(0);
        Double currentTotalMoney = queryMember.getTotalMoney()+order.getMustPay();
        member.setTotalMoney(currentTotalMoney);
        /**
         * 
         * id
         */
        Integer mcId = queryMember.getMemberCategory().getMcId();
        List<MemberCategory> categoryList = memberCategoryDao.findAll();
        for(MemberCategory category:categoryList){
            if(currentTotalMoney>=category.getAmount()){
                mcId = category.getMcId();
            }
        }

        MemberCategory memberCategory = new MemberCategory();
        memberCategory.setMcId(mcId);
        //id
        member.setMemberCode(null);
        member.setMemberId(queryMember.getMemberId());
        member.setMemberCategory(memberCategory);
        memberDao.update(member);
        if(effect<=0){
            throw  new CustomException(ResultEnum.UPDATE_DB_FAIL);
        }
    }
}
