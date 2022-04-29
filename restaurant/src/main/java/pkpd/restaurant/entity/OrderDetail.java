package pkpd.restaurant.entity;

import java.util.List;

/**
 * Created with IDEA
 * author:Jeff Li
 * Date:2020/10/1
 * Time:23:19
 *
 * 
 */

public class OrderDetail extends BaseBean{
    /**
     * id
     */
    private Long odId;
    /**
     * 
     */
    private Order order;
    /**
     * 
     */
    private Goods goods;
    /**
     * 
     */
    private Integer count;
    /**
     * (0，1，2，3)
     */
    private Integer status;
    /**
     * 
     */
    private String description;
    /**
     * id
     */
    private List<Long> odIdList;

    public Long getOdId() {
        return odId;
    }

    public void setOdId(Long odId) {
        this.odId = odId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getOdIdList() {
        return odIdList;
    }

    public void setOdIdList(List<Long> odIdList) {
        this.odIdList = odIdList;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "odId=" + odId +
                ", order=" + order +
                ", goods=" + goods +
                ", count=" + count +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", odIdList=" + odIdList +
                '}';
    }
}
