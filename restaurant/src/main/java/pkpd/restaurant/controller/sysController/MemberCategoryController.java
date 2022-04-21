package pkpd.restaurant.controller.sysController;

import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.entity.Member;
import pkpd.restaurant.entity.MemberCategory;
import pkpd.restaurant.entity.Result;
import pkpd.restaurant.service.MemberCategoryService;
import pkpd.restaurant.utils.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/membercategory")
public class MemberCategoryController {
    @Autowired
    private MemberCategoryService memberCategoryService;

    @GetMapping("/list.html")
    @RequiresPermissions("memberTypes:view")
    public String memberList(){
        return "membercategory/list";
    }

    @GetMapping("/add.html")
    @RequiresPermissions("memberTypes:edit")
    public String addMember(){
        return "membercategory/add";
    }

    @PostMapping("/add.do")
    @RequiresPermissions("memberTypes:edit")
    @ResponseBody
    public Result<Member> addMember(MemberCategory memberCategory){
        memberCategoryService.insert(memberCategory);
        return ResultUtil.success();
    }

    @GetMapping("/edit.html/{mcId}")
    @RequiresPermissions("memberTypes:edit")
    public String editMember(@PathVariable("mcId") Long mcId, Model model){
        model.addAttribute("memberCategory",memberCategoryService.findById(mcId));
        return "membercategory/edit";
    }

    @PostMapping("/edit.do")
    @RequiresPermissions("memberTypes:edit")
    @ResponseBody
    public Result<Member> editMember(MemberCategory category){
       memberCategoryService.update(category);
        return ResultUtil.success();
    }

    @PostMapping("/del.do")
    @RequiresPermissions("memberTypes:edit")
    @ResponseBody
    public Result<MemberCategory> deleteMember(@RequestParam String ids){
        memberCategoryService.deleteByIds(ids);
        return ResultUtil.success();
    }

    /**
     * 
     * @return
     */
    @PostMapping("/list.do")
    @RequiresPermissions("memberTypes:view")
    @ResponseBody
    public Result<List<MemberCategory>> memberListData(){
        List<MemberCategory> categoryList = memberCategoryService.findAll();
        Result<List<MemberCategory>> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(categoryList);
        result.setCount((long) categoryList.size());
        return result;
    }
}
