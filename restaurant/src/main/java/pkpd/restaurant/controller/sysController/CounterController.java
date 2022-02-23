package pkpd.restaurant.controller.sysController;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/counter")
public class CounterController {
    @GetMapping("/counterPage.html")
    @RequiresPermissions("counter:view")
    private String counterPage(){
        return "counter/counter";
    }
}
