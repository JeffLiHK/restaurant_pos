package pkpd.restaurant.controller.sysController;

import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.entity.*;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Member;
import pkpd.restaurant.entity.MemberCategory;
import pkpd.restaurant.entity.Result;
import pkpd.restaurant.entity.SysUser;
import pkpd.restaurant.service.MemberCategoryService;
import pkpd.restaurant.service.MemberService;
import pkpd.restaurant.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberCategoryService memberCategoryService;
    /**
     * html
     * @param model
     * @return
     */
    @GetMapping("/list.html")
    @RequiresPermissions("memberManage:view")
    public String memberList(Model model){
        model.addAttribute("memberCategoryList",memberCategoryService.findAll());
        SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("user");
        model.addAttribute("role",user.getRole());
        return "member/list";
    }

    @GetMapping("/add.html")
    @RequiresPermissions("memberManage:edit")
    public String addMember(Model model){
        model.addAttribute("memberCategoryList",memberCategoryService.findAll());
        return "member/add";
    }


    @PostMapping("/add.do")
    @RequiresPermissions("memberManage:edit")
    @ResponseBody
    public Result<Member> addMember(Member member, MemberCategory memberCategory){
        member.setMemberCategory(memberCategory);
        memberService.addMember(member);
        return ResultUtil.success();
    }

    @GetMapping("/edit.html/{memberId}")
    @RequiresPermissions("memberManage:edit")
    public String editMember(@PathVariable("memberId") Long memberId, Model model){
        Member member = new Member();
        member.setMemberId(memberId);
        Member resultMember = memberService.findMemberById(member);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sf.format(resultMember.getBirthday());
        model.addAttribute("member",resultMember);
        model.addAttribute("birthday",birthday);
        model.addAttribute("memberCategoryList",memberCategoryService.findAll());
        return "member/edit";
    }

    @PostMapping("/edit.do")
    @RequiresPermissions("memberManage:edit")
    @ResponseBody
    public Result<Member> editMember(Member member,MemberCategory memberCategory){
        member.setMemberCategory(memberCategory);
        memberService.update(member);
        return ResultUtil.success();
    }

    @PostMapping("/del.do")
    @RequiresPermissions("memberManage:edit")
    @ResponseBody
    public Result<Member> deleteMember(@RequestParam String ids){
        memberService.deleteByIds(ids);
        return ResultUtil.success();
    }
    /**
     * 
     * @param pageInfo pageNum、pageSize
     * @param member 
     * @param memberCategory id
     * @return
     */
    @PostMapping("/list.do")
    @RequiresPermissions("memberManage:view")
    @ResponseBody
    public Result<List<Member>> memberList(CustomPageInfo<Member> pageInfo, Member member,
                                           MemberCategory memberCategory){
        member.setMemberCategory(memberCategory);
        pageInfo.setT(member);
        CustomPageInfo<Member> resultPageInfo = memberService.findPage(pageInfo);
        Result<List<Member>> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setCount(resultPageInfo.getTotal());
        result.setData(resultPageInfo.getList());
        return result;
    }

    /**
     * 
     * @param member
     * @return
     */
    @GetMapping("/findMemberByMemberCode.do")
    @ResponseBody
    public Result<Member> findMemberByMemberCode(Member member){
        Member resultMember = memberService.findMemberByMemberCode(member);
        return ResultUtil.success(resultMember);
    }
}
