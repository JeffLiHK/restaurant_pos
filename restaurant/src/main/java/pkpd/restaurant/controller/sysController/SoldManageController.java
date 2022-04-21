package pkpd.restaurant.controller.sysController;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Member;
import pkpd.restaurant.entity.Order;
import pkpd.restaurant.entity.Result;
import pkpd.restaurant.service.OrderService;
import pkpd.restaurant.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sold")
public class SoldManageController {
    @Autowired
    private OrderService orderService;

    /**
     * HTML
     * @return
     */
    @GetMapping("/tranRecordsList.html")
    public String transactionRecordsList(){
        return "sold/transactionRecordsList";
    }

    /**
     * 
     * @param pageInfo
     * @param order
     * @return
     */
    @PostMapping("/tranRecordsList.do")
    @ResponseBody
    public Result<Order> orderList(CustomPageInfo<Order> pageInfo, Order order, Member member){
        //，1
        order.setPayStatus(1);
        order.setMember(member);
        pageInfo.setT(order);
        //
        pageInfo.setOrderBy("DESC");
        CustomPageInfo<Order> resultInfo =  orderService.findPage(pageInfo);
        return ResultUtil.success(resultInfo.getList(),resultInfo.getTotal());
    }
}
