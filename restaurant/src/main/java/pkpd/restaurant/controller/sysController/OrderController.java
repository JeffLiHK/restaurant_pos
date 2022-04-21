package pkpd.restaurant.controller.sysController;

import pkpd.restaurant.entity.*;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Order;
import pkpd.restaurant.entity.OrderDetail;
import pkpd.restaurant.entity.Result;
import pkpd.restaurant.entity.SysUser;
import pkpd.restaurant.service.OrderDetailService;
import pkpd.restaurant.service.OrderService;
import pkpd.restaurant.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/list.html")
    public String orderList(){
        return "/order/list";
    }

    @PostMapping("/list.do")
    @ResponseBody
    public Result<Order> orderList(CustomPageInfo<Order> pageInfo, Order order){
        //，（、）
        order.setOverStatus(0);
        pageInfo.setT(order);
        pageInfo.setOrderBy("ASC");
       CustomPageInfo<Order> resultInfo =  orderService.findPage(pageInfo);
        return ResultUtil.success(resultInfo.getList(),resultInfo.getTotal());
    }

    @GetMapping("/viewdetail.html/{orderId}")
    public String viewOrderDetail(@PathVariable(value = "orderId") Long orderId, Model model){
        model.addAttribute("orderId",orderId);
        return "order/orderDetail";
    }

    @GetMapping("/viewdetail.do/{orderId}")
    @ResponseBody
    public Result<OrderDetail> viewOrderDetail(CustomPageInfo pageInfo, @PathVariable(value = "orderId") Long orderId){
       OrderDetail detail = new OrderDetail();
       Order order = new Order();
       order.setOrderId(orderId);
       detail.setOrder(order);
       pageInfo.setT(detail);
       CustomPageInfo<OrderDetail> resultInfo = orderDetailService.findPage(pageInfo);
       return ResultUtil.success(resultInfo.getList(),resultInfo.getTotal());
    }

    @PostMapping("/del.do")
    @ResponseBody
    public Result<Order> deleteByIds(@RequestParam("ids") String ids){
        orderService.deleteByIds(ids);
        return ResultUtil.success();
    }

    @PostMapping("/deldetail.do")
    @ResponseBody
    public Result<OrderDetail> deleteByOrderDetailIds(@RequestParam("ids") String ids){
        orderDetailService.deleteByIds(ids);
        return ResultUtil.success();
    }

    /**
     * 
     * @param deskCode
     * @return
     */
    @RequestMapping("/findDetail.do")
    @ResponseBody
    public Result<OrderDetail> findOrderDetailByDeskCode(@RequestParam("deskCode") String deskCode){
      List<OrderDetail> resultList =  orderDetailService.findOrderDetailsByDeskCode(deskCode);
        return ResultUtil.success(resultList,new Long(resultList.size()));
    }

    /**
     * 
     * @return
     */
    @PostMapping("/settleAccounts.do")
    @ResponseBody
    public Result<Order> settleAccounts(@RequestBody Order order, HttpSession session){
        SysUser user = (SysUser) session.getAttribute("user");
        //
        order.setCashier(user);
        orderService.settleAccounts(order);
        return ResultUtil.success();
    }
}
