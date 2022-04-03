package pkpd.restaurant.controller.sysController;

import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.entity.Member;
import pkpd.restaurant.entity.GoodsCategory;
import pkpd.restaurant.entity.Result;
import pkpd.restaurant.service.GoodsCategoryService;
import pkpd.restaurant.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/goodscategory")
public class GoodsCategoryController{
    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @GetMapping("/list.html")
    public String memberList(){
        return "goodscategory/list";
    }


    @GetMapping("/add.html")
    public String addMember(){
        return "goodscategory/add";
    }

    @PostMapping("/add.do")
    @ResponseBody
    public Result<Member> addMember(GoodsCategory GoodsCategory){
        goodsCategoryService.insert(GoodsCategory);
        return ResultUtil.success();
    }

    @GetMapping("/edit.html/{mcId}")
    public String editMember(@PathVariable("mcId") Long mcId, Model model){
        model.addAttribute("goodsCategory",goodsCategoryService.findById(mcId));
        return "goodscategory/edit";
    }

    @PostMapping("/edit.do")
    @ResponseBody
    public Result<Member> editMember(GoodsCategory category){
        goodsCategoryService.update(category);
        return ResultUtil.success();
    }

    @PostMapping("/del.do")
    @ResponseBody
    public Result<GoodsCategory> deleteMember(@RequestParam String ids){
        goodsCategoryService.deleteByIds(ids);
        return ResultUtil.success();
    }

    /**
     * 菜品类型
     * @return
     */
    @PostMapping("/list.do")
    @ResponseBody
    public Result<List<GoodsCategory>> memberListData(){
        List<GoodsCategory> categoryList = goodsCategoryService.findAll();
        Result<List<GoodsCategory>> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(categoryList);
        result.setCount((long) categoryList.size());
        return result;
    }
}
