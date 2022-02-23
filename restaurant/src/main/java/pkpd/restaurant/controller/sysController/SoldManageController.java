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
     * 交易记录列表HTML页面
     * @return
     */
    @GetMapping("/tranRecordsList.html")
    public String transactionRecordsList(){
        return "sold/transactionRecordsList";
    }

    /**
     * 交易记录列表数据接口
     * @param pageInfo
     * @param order
     * @return
     */
    @PostMapping("/tranRecordsList.do")
    @ResponseBody
    public Result<Order> orderList(CustomPageInfo<Order> pageInfo, Order order, Member member){
        //交易记录是已支付订单，状态为1
        order.setPayStatus(1);
        order.setMember(member);
        pageInfo.setT(order);
        //按时间降序
        pageInfo.setOrderBy("DESC");
        CustomPageInfo<Order> resultInfo =  orderService.findPage(pageInfo);
        return ResultUtil.success(resultInfo.getList(),resultInfo.getTotal());
    }
}
