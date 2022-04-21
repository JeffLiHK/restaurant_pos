package pkpd.restaurant.controller.sysController;

import pkpd.restaurant.entity.*;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Order;
import pkpd.restaurant.entity.OrderDetail;
import pkpd.restaurant.entity.Result;
import pkpd.restaurant.entity.SysUser;
import pkpd.restaurant.service.CookAndServingService;
import pkpd.restaurant.service.OrderDetailService;
import pkpd.restaurant.service.OrderService;
import pkpd.restaurant.utils.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("/service")
public class CookAndServingController{
    @Autowired
    private CookAndServingService cookAndServingService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * HTML
     * @return
     */
    @GetMapping("/cookTask.html")
    @RequiresPermissions("cooking:view")
    public String cookTaskList(HttpSession session,Model model){
        SysUser user = (SysUser) session.getAttribute("user");
        model.addAttribute("role",user.getRole());
        return "cook/cookTaskList";
    }

    /**
     * 
     * @param pageInfo
     * @return
     */
    @GetMapping("/cookTask.do")
    @RequiresPermissions("cooking:view")
    @ResponseBody
    public Result<OrderDetail> cookTaskList(CustomPageInfo<OrderDetail> pageInfo){
        List<OrderDetail> resultList = cookAndServingService.cookTaskFindPage(pageInfo);
        return ResultUtil.success(resultList,new Long((resultList.size())));
    }

    /**
     * 
     * ，List，value = "odIdList[]
     * @param odIdList
     * @return
     */
    @PostMapping("/startCook.do")
    @RequiresPermissions("cooking:edit")
    @ResponseBody
    public Result<OrderDetail> startCook(@RequestParam(value = "odIdList[]") List<Long> odIdList){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setStatus(1);
        orderDetail.setOdIdList(odIdList);
        cookAndServingService.updateStatusByOdIds(orderDetail);
        return ResultUtil.success();
    }

    /**
     * 
     * ，List，value = "odIdList[]
     * @param odIdList
     * @return
     */
    @PostMapping("/finishCook.do")
    @RequiresPermissions("cooking:edit")
    @ResponseBody
    public Result<OrderDetail> finishCook(@RequestParam(value = "odIdList[]") List<Long> odIdList){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setStatus(2);
        orderDetail.setOdIdList(odIdList);
        cookAndServingService.updateStatusByOdIds(orderDetail);
        return ResultUtil.success();
    }

    /**
     * HTML
     * @return
     */
    @GetMapping("/servingTask.html")
    @RequiresPermissions("serving:view")
    public String servingTaskList(HttpSession session,Model model){
        SysUser user = (SysUser) session.getAttribute("user");
        model.addAttribute("role",user.getRole());
        return "cook/servingTaskList";
    }

    /**
     * 
     * @param pageInfo
     * @return
     */
    @GetMapping("/servingTask.do")
    @RequiresPermissions("serving:view")
    @ResponseBody
    public Result<OrderDetail> servingTask(CustomPageInfo<OrderDetail> pageInfo){
        CustomPageInfo<OrderDetail> resultInfo = cookAndServingService.servingTaskFindPage(pageInfo);
        return ResultUtil.success(resultInfo.getList(),resultInfo.getTotal());
    }

    /**
     * 
     * @param orderDetail
     * @param order
     * @return
     */
    @GetMapping("/finishServing.do")
    @RequiresPermissions("serving:edit")
    @ResponseBody
    public Result<OrderDetail> finishServing(OrderDetail orderDetail, Order order){
        orderDetail.setOrder(order);
        cookAndServingService.finishServing(orderDetail);
        return ResultUtil.success();
    }

    /**
     * HTML
     * @return
     */
    @GetMapping("/dssList.html")
    @RequiresPermissions("deskServing:view")
    public String deskServingStatusList(){
        return "/cook/deskServingStatus";
    }

    /**
     * 
     * @param pageInfo
     * @param order
     * @return
     */
    @PostMapping("/dssList.do")
    @RequiresPermissions("deskServing:view")
    @ResponseBody
    public Result<Order> deskServingStatusList(CustomPageInfo<Order> pageInfo,Order order){
        order.setOverStatus(0);
        pageInfo.setT(order);
        CustomPageInfo<Order> resultInfo =  orderService.findPage(pageInfo);
        return ResultUtil.success(resultInfo.getList(),resultInfo.getTotal());
    }

    /**
     * HTML
     * @param orderId
     * @param model
     * @return
     */
    @GetMapping("/ssd.html/{orderId}")
    @RequiresPermissions("deskServing:view")
    public String servingStatusDetail(@PathVariable(value = "orderId") Long orderId, Model model){
        model.addAttribute("orderId",orderId);
        return "cook/servingStatusDetail";
    }

    /**
     * 
     * @param pageInfo
     * @param orderId
     * @return
     */
    @GetMapping("/ssd.do/{orderId}")
    @RequiresPermissions("deskServing:view")
    @ResponseBody
    public Result<OrderDetail> servingStatusDetail(CustomPageInfo pageInfo,@PathVariable(value = "orderId") Long orderId){
        OrderDetail detail = new OrderDetail();
        Order order = new Order();
        order.setOrderId(orderId);
        detail.setOrder(order);
        pageInfo.setT(detail);
        CustomPageInfo<OrderDetail> resultInfo = orderDetailService.findPage(pageInfo);
        return ResultUtil.success(resultInfo.getList(),resultInfo.getTotal());
    }
}
