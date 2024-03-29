package pkpd.restaurant.controller.sysController;

import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Result;
import pkpd.restaurant.entity.SysRole;
import pkpd.restaurant.entity.SysUser;
import pkpd.restaurant.entity.request.UserRequest;
import pkpd.restaurant.service.SysUserService;
import pkpd.restaurant.utils.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 
     * @param userRequest
     * @return
     */

    @PostMapping("/userlist.do")
    @RequiresPermissions("userManage:view")
    @ResponseBody
    public Result<List<SysUser>> userList(UserRequest userRequest){
        SysRole role = new SysRole();
        role.setRoleId(userRequest.getRoleId());
        userRequest.setRole(role);
        CustomPageInfo pageInfo = sysUserService.findPage(userRequest);
        Result<List<SysUser>> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setCount(pageInfo.getTotal());
        result.setData(pageInfo.getList());
        return result;
    }

    /**
     * html
     * @param model
     * @return
     */
    @GetMapping("/userlist.html")
    @RequiresPermissions("userManage:view")
    public String userList(Model model){
        model.addAttribute("roleList",sysUserService.findRoleList());
        return "user/userList";
    }

    /**
     * 
     * @return
     */
    @GetMapping("/adduser.html")
    @RequiresPermissions("userManage:edit")
    public String addUser(Model model){
        model.addAttribute("roleList",sysUserService.findRoleList());
        return "user/addUser";
    }

    @PostMapping("/adduser.do")
    @RequiresPermissions("userManage:edit")
    @ResponseBody
    public Result<SysUser> addUser(SysUser user,SysRole role){
        user.setRole(role);
        sysUserService.addUser(user);
        return ResultUtil.success();
    }

    /**
     * 
     * @return
     */

    @GetMapping("/edituser.html/{userId}")
    @RequiresPermissions("userManage:edit")
    public String editUser(@PathVariable("userId") Long userId,Model model){
        SysUser user = sysUserService.findById(userId);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sf.format(user.getBirthday());
        model.addAttribute("user",user);
        model.addAttribute("birthday",birthday);
        model.addAttribute("roleList",sysUserService.findRoleList());
        return "user/editUser";
    }

    @PostMapping("/saveEdit.do")
    @ResponseBody
    public Result<SysUser> saveEdit(SysUser user,SysRole role,HttpSession session){
        user.setRole(role);
        sysUserService.update(user);
        SysUser curUser = (SysUser) session.getAttribute("user");
        //，session
        if(curUser.getUserId()==user.getUserId()){
            SysUser sysUser = sysUserService.findById(user.getUserId());
            session.setAttribute("user",sysUser);
        }
        return ResultUtil.success();
    }

    @PostMapping("/del.do")
    @RequiresPermissions("userManage:edit")
    @ResponseBody
    public Result<SysUser> delete(@RequestParam String ids){
        sysUserService.deleteByIds(ids);
        return ResultUtil.success("Delete Successfully！");
    }


    @GetMapping("/resetpwd/{userId}")
    @RequiresPermissions("userManage:edit")
    @ResponseBody
    public Result<SysUser> resetPwd(@PathVariable("userId") Long userId){
        SysUser user = new SysUser();
        user.setPassword("123456");
        user.setUserId(userId);
        sysUserService.resetPwd(user);
        return ResultUtil.success();
    }

    /**
     * 
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/curuserinfo.html")
    public String currentUserInfo(HttpSession session,Model model){
        SysUser currentUser = (SysUser) session.getAttribute("user");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("currentUser", currentUser);
        String birthday = sf.format(currentUser.getBirthday());
        model.addAttribute("birthday",birthday);
        model.addAttribute("roleList",sysUserService.findRoleList());
        return "user/userInfo";
    }

    /**
     * 
     * @return
     */
    @GetMapping("/updatepwd.html")
    public String updatePwd(){
        return "user/updatePwd";
    }

    @PostMapping("/updatepwd.do")
    @ResponseBody
    public Result<SysUser> updatePwd(SysUser user){
        sysUserService.updatePwd(user);
        return ResultUtil.success();
    }
}
