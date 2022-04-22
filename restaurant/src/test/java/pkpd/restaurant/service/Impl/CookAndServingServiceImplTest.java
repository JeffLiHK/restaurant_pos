package pkpd.restaurant.service.Impl;

import pkpd.restaurant.dao.OrderDetailDao;
import pkpd.restaurant.entity.OrderDetail;
import pkpd.restaurant.service.CookAndServingService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CookAndServingServiceImplTest {
    @Autowired
    private CookAndServingService cookAndServingService;
    @Autowired
    private OrderDetailDao orderDetailDao;

    /**
     * 
     */
    @Test
    @Ignore
    public void cookTaskManage() {
        List<Integer> statusList = new ArrayList<>();
        //
        statusList.add(1);
        List<OrderDetail> resultCookTaskList = orderDetailDao.findPageByStatus(statusList);
        cookAndServingService.cookTaskManage(resultCookTaskList);
        //
        statusList.clear();
        statusList.add(0);
        List<OrderDetail> cookingTaskList = orderDetailDao.findPageByStatus(statusList);
        cookAndServingService.cookTaskManage(cookingTaskList);
        resultCookTaskList.addAll(cookingTaskList);
    }
}