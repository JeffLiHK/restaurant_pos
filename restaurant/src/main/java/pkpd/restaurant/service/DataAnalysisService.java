package pkpd.restaurant.service;

import pkpd.restaurant.entity.chart.*;
import pkpd.restaurant.entity.chart.GoodsCategorySalesChart;
import pkpd.restaurant.entity.chart.GoodsSalesChart;
import pkpd.restaurant.entity.chart.MemberChart;
import pkpd.restaurant.entity.chart.PeopleChart;
import pkpd.restaurant.entity.chart.SalesStatisticsChart;

import java.util.List;

public interface DataAnalysisService {
    /**
     * top
     * day 
     * number top
     * @return
     */
     List<GoodsSalesChart> findSalesSortByDays(GoodsSalesChart goodsSalesChart);
    /**
     * 
     * @param goodsCategorySalesChart
     * @return
     */
    List<GoodsCategorySalesChart> findGoodsCategorySalesByDays(GoodsCategorySalesChart goodsCategorySalesChart);

    /**
     * 
     * @param salesStatisticsChart
     * @return
     */
    List<SalesStatisticsChart> findSalesStatisticsByDays(SalesStatisticsChart salesStatisticsChart);

    /**
     * 
     * @param memberChart
     * @return
     */
    List<MemberChart> findMemberAddByDays(MemberChart memberChart);

    /**
     * 
     * @return
     */
    List<MemberChart> findMemberCategoryRate();
    /**
     * 
     * @return
     */
    List<PeopleChart> findPeopleByHours();
}
