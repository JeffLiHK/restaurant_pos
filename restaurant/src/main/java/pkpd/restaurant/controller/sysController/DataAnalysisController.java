package pkpd.restaurant.controller.sysController;

import pkpd.restaurant.entity.Result;
import pkpd.restaurant.entity.chart.*;
import pkpd.restaurant.entity.chart.GoodsCategorySalesChart;
import pkpd.restaurant.entity.chart.GoodsSalesChart;
import pkpd.restaurant.entity.chart.MemberChart;
import pkpd.restaurant.entity.chart.PeopleChart;
import pkpd.restaurant.entity.chart.SalesStatisticsChart;
import pkpd.restaurant.service.DataAnalysisService;
import pkpd.restaurant.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 
 */
@Controller
@RequestMapping("/analysis")
public class DataAnalysisController{
    @Autowired
    private DataAnalysisService dataAnalysisService;
    /**
     * HTML
     * @return
     */
    @GetMapping("/salesVolume.html")
    public String salesVolume(){
        return "chart/salesVolume";
    }

    /**
     * HTML
     * @return
     */
    @GetMapping("/salesStatistics.html")
    public String salesStatistics(){
        return "/chart/salesStatistics";
    }

    /**
     * top10
     * @return
     */
    @GetMapping("/gssByDays.do")
    @ResponseBody
    public Result<GoodsSalesChart> goodsSalesSortByDays(GoodsSalesChart goodsSalesChart){
        //top12
        goodsSalesChart.setNumber(12);
        List<GoodsSalesChart> result = dataAnalysisService.findSalesSortByDays(goodsSalesChart);
        return ResultUtil.success(result,new Long(result.size()));
    }
    /**
     * 
     * @return
     */
    @GetMapping("/gwcByDays.do")
    @ResponseBody
    public Result<GoodsSalesChart> goodsWordCloudBynDays(GoodsSalesChart goodsSalesChart){
        //top12
        goodsSalesChart.setNumber(20);
        List<GoodsSalesChart> result = dataAnalysisService.findSalesSortByDays(goodsSalesChart);
        return ResultUtil.success(result,new Long(result.size()));
    }
    /**
     * 
     * @return
     */
    @GetMapping("/gcsByDays.do")
    @ResponseBody
    public Result<GoodsCategorySalesChart> goodsCategorySalesByDays(GoodsCategorySalesChart gcsChart){
        List<GoodsCategorySalesChart> result = dataAnalysisService.findGoodsCategorySalesByDays(gcsChart);
        return ResultUtil.success(result,new Long(result.size()));
    }

    /**
     * 
     * @return
     */
    @GetMapping("/ssByDays.do")
    @ResponseBody
    public Result<SalesStatisticsChart> salesStatisticsByDay(SalesStatisticsChart ssChart){
        List<SalesStatisticsChart> result = dataAnalysisService.findSalesStatisticsByDays(ssChart);
        return ResultUtil.success(result,new Long(result.size()));
    }

    /**
     * 
     * @param memberChart
     * @return
     */
    @GetMapping("/mAddByDays.do")
    @ResponseBody
    public Result<MemberChart> memberAddByDays(MemberChart memberChart){
        List<MemberChart> result  = dataAnalysisService.findMemberAddByDays(memberChart);
        return ResultUtil.success(result,new Long(result.size()));
    }

    /**
     * 
     * @return
     */
    @GetMapping("/mcRate.do")
    @ResponseBody
    public Result<MemberChart> memberCategoryRate(){
        List<MemberChart> result  = dataAnalysisService.findMemberCategoryRate();
        return ResultUtil.success(result,new Long(result.size()));
    }
    /**
     * (8-24)
     * @return
     */
    @GetMapping("/peopleByHour.do")
    @ResponseBody
    public Result<PeopleChart> peopleByHours(){
        List<PeopleChart> result  = dataAnalysisService.findPeopleByHours();
        return ResultUtil.success(result,new Long(result.size()));
    }
}
