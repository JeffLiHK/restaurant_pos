package pkpd.restaurant.controller.clientController;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Order;
import pkpd.restaurant.entity.OrderDetail;
import pkpd.restaurant.entity.Result;
import pkpd.restaurant.service.OrderDetailService;
import pkpd.restaurant.service.OrderService;
import pkpd.restaurant.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guest/client")
public class ClientOrderController{
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    /**
     * 
     * @return
     */
    @PostMapping("/addorder.do")
    @ResponseBody
    private Result addOrder(@RequestBody Order order){
        String orderCode = orderService.addOrder(order);
        return ResultUtil.success(orderCode);
    }

    @GetMapping("/myOrder.do")
    @ResponseBody
    private Result<OrderDetail> myOrder(CustomPageInfo info,Order order){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        info.setT(orderDetail);
        CustomPageInfo<OrderDetail> resultInfo =  orderDetailService.findPage(info);
        System.out.println(resultInfo.getList());
        return ResultUtil.success(resultInfo.getList(),resultInfo.getTotal());
    }

    @GetMapping("/myOrder.html")
    public String viewOrderDetail(@RequestParam("orderCode") String orderCode, Model model){
        model.addAttribute("orderCode",orderCode);
        return "/client/myOrder";
    }

    @PostMapping("/delGood.do")
    @ResponseBody
    public Result<OrderDetail> deleteByOrderDetailIds(@RequestParam("ids") String ids){
        orderDetailService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
