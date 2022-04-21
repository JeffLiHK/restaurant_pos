package pkpd.restaurant.service.Impl;

import pkpd.restaurant.dao.DataAnalysisDao;
import pkpd.restaurant.entity.chart.*;
import pkpd.restaurant.entity.chart.GoodsCategorySalesChart;
import pkpd.restaurant.entity.chart.GoodsSalesChart;
import pkpd.restaurant.entity.chart.MemberChart;
import pkpd.restaurant.entity.chart.PeopleChart;
import pkpd.restaurant.entity.chart.SalesStatisticsChart;
import pkpd.restaurant.service.DataAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 */
@Service
public class DataAnalysisServiceImpl implements DataAnalysisService {
    @Autowired
    private DataAnalysisDao dataAnalysisDao;

    /**
     * top
     * day 
     * number top
     * @return
     */
    @Override
    public List<GoodsSalesChart> findSalesSortByDays(GoodsSalesChart goodsSalesChart) {
        return dataAnalysisDao.findSalesSortByDays(goodsSalesChart);
    }
    /**
     * 
     * @param gcsChart
     * @return
     */
    @Override
    public List<GoodsCategorySalesChart> findGoodsCategorySalesByDays(GoodsCategorySalesChart gcsChart) {
        return dataAnalysisDao.findGoodsCategorySalesByDays(gcsChart);
    }

    /**
     * 
     * @param salesStatisticsChart
     * @return
     */
    @Override
    public List<SalesStatisticsChart> findSalesStatisticsByDays(SalesStatisticsChart salesStatisticsChart){
        return dataAnalysisDao.findSalesStatisticsByDays(salesStatisticsChart);
    }
    /**
     * 
     * @param memberChart
     * @return
     */
    @Override
    public List<MemberChart> findMemberAddByDays(MemberChart memberChart) {
        return dataAnalysisDao.findMemberAddByDays(memberChart);
    }
    /**
     * 
     * @return
     */
    @Override
    public List<MemberChart> findMemberCategoryRate() {
        return dataAnalysisDao.findMemberCategoryRate();
    }
    /**
     * 
     * @return
     */
    @Override
    public List<PeopleChart> findPeopleByHours() {
        return dataAnalysisDao.findPeopleByHours();
    }
}
