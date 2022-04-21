package pkpd.restaurant.controller.clientController;

import pkpd.restaurant.entity.*;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Desk;
import pkpd.restaurant.entity.Goods;
import pkpd.restaurant.entity.GoodsCategory;
import pkpd.restaurant.entity.Result;
import pkpd.restaurant.service.DeskService;
import pkpd.restaurant.service.GoodsCategoryService;
import pkpd.restaurant.service.GoodsService;
import pkpd.restaurant.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/guest")
public class ClientDeskController{

    @Autowired
    private DeskService deskService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsCategoryService goodsCategoryService;
    /**
     * 
     */
    @PostMapping("/login.do")
    @ResponseBody
    private Result deskLogin(Desk desk, HttpSession session){
        deskService.login(desk);
        session.setAttribute("deskCode",desk.getDeskCode());
        return ResultUtil.success();
    }

    @GetMapping("/logout.do/{deskCode}")
    private String deskLoginOut(@PathVariable("deskCode") String deskCode,HttpSession session){
        Desk desk = new Desk();
        desk.setDeskCode(deskCode);
        deskService.logout(desk);
        session.removeAttribute("deskCode");
        return "redirect:/guest/desklist.html";
    }

    @GetMapping("/desklist.html")
    private String deskList(Model model, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        CustomPageInfo<Desk> customPageInfo = new CustomPageInfo<>();
        customPageInfo.setPageSize(15);
        customPageInfo.setPageNum(pageNum);
        model.addAttribute("page",deskService.findPage(customPageInfo));
        return "/client/deskPage";
    }

    @GetMapping("/main.html")
    private String clientMain(Model model){
        model.addAttribute("categoryList",goodsCategoryService.findAll());
        return "/client/main";
    }

    @GetMapping("/goodspage.thml")
    private String goodsPage(){
        return "/client/goodsPage";
    }

    /**
     * html
     * @param model
     * @return
     */
    @GetMapping("/goodslist.html/{categoryId}")
    public String goodsList(Model model,@PathVariable("categoryId") Integer categoryId){
        //0，
        if (categoryId==0){
            categoryId=null;
        }
        model.addAttribute("categoryId",categoryId);
        return "/client/goodsPage";
    }

    /**
     * 
     * @param pageInfo
     * @param goods
     * @param goodsCategory
     * @return
     */
    @PostMapping("/goodslist.do")
    @ResponseBody
    public Result<Goods> goodsList(CustomPageInfo<Goods> pageInfo, Goods goods, GoodsCategory goodsCategory){
        goods.setGoodsCategory(goodsCategory);
        goods.setPutawayStatus(1);
        pageInfo.setT(goods);
        CustomPageInfo<Goods> resultPage = goodsService.findPage(pageInfo);
        return ResultUtil.success(resultPage.getList(),resultPage.getTotal());
    }
}
