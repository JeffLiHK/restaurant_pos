package pkpd.restaurant.dao;


import pkpd.restaurant.entity.chart.*;
import org.apache.ibatis.annotations.Mapper;
import pkpd.restaurant.entity.chart.GoodsCategorySalesChart;
import pkpd.restaurant.entity.chart.GoodsSalesChart;
import pkpd.restaurant.entity.chart.MemberChart;
import pkpd.restaurant.entity.chart.PeopleChart;
import pkpd.restaurant.entity.chart.SalesStatisticsChart;

import java.util.List;

/**
 *
 */
@Mapper
public interface DataAnalysisDao {

    /**
     * top
     * @param goodsSalesChart
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
