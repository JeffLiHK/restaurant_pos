package pkpd.restaurant.controller.sysController;

import pkpd.restaurant.entity.Result;
import pkpd.restaurant.entity.SysUser;
import pkpd.restaurant.service.SysUserService;
import pkpd.restaurant.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created with IDEA
 * author:LiuJing
 * Date:2018/10/2
 * Time:15:20
 *
 * 
 */
@Controller
@RequestMapping("/sysuser")
public class LoginController{
   @Autowired
   private SysUserService sysUserService;
    /**
     *  @Valid    BindingResult
     */
    @PostMapping(value = "/login.do")
    @ResponseBody
    public Result<SysUser> login(@Valid SysUser user, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            //202 
            return ResultUtil.error(202,bindingResult.getFieldError().getDefaultMessage());
        }

        //
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginCode(),user.getPassword());
        System.out.println(session.getMaxInactiveInterval());
        //shiro
        subject.login(token);
        //
        return ResultUtil.success();
    }

    /**
     * 
     * @return
     */
    @GetMapping("/logout.do")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        //session
        subject.getSession().removeAttribute("user");
        return "redirect:login.html";
    }
    /**
     * 
     * @return
     */
    @GetMapping("/login.html")
    public String login(HttpSession session){
        return "login/login";
    }

    /**
     * 
     * @return
     */
    @GetMapping("/admin.html")
    public String admin(HttpSession session, Model model){
        SysUser sysUser = (SysUser) session.getAttribute("user");
        //
       model.addAttribute("menuList",sysUserService.findMenuTreeByUser(sysUser));
        return "admin";
    }

    /**
     * 
     * @return
     */
   @GetMapping("/console.html")
    public String console(){
        return "home/console";
    }
    @GetMapping("/403.html")
    public String eorror(){
       return "eorror/403";
    }
}
