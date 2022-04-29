package pkpd.restaurant.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:Jeff Li
 * Date:2020/10/1
 * Time:23:12
 *
 * 
 */

public class Order extends BaseBean{
    /**
     * id
     */
    private Long orderId;
    /**
     * 
     */
    private String orderCode;
    /**
     * 
     */
    private String deskCode;
    /**
     * 
     */
    private SysUser cashier;
    /**
     * 
     */
    private Member member;
    /**
     * 
     */
    private Double totalCost;
    /**
     * 
     */
    private Double totalPrice;
    /**
     * 
     */
    private Double totalProfit;
    /**
     * 
     */
    private Double actualPay;
    /**
     * 
     */
    private Double mustPay;
    /**
     * 
     */
    private Double changeMoney;
    /**
     * 
     */
    private  Double discountMoney;
    /**
     * 
     */
    private Integer peopleNum;
    /**
     * (0，1)
     */
    private Integer payStatus;
    /**
     *（0，1）
     */
    private Integer finishStatus;
    /**
     * (0，1)
     */
    private Integer overStatus;
    /**
     * ，
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//Stringdate
    private Date startTime;
    /**
     * ，
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//Stringdate
    private Date endTime;

    private List<OrderDetail> orderDetails;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost){
        this.totalCost = totalCost;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(Integer finishStatus) {
        this.finishStatus = finishStatus;
    }

    public String getDeskCode() {
        return deskCode;
    }

    public void setDeskCode(String deskCode) {
        this.deskCode = deskCode;
    }

    public Double getActualPay() {
        return actualPay;
    }

    public void setActualPay(Double actualPay) {
        this.actualPay = actualPay;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Double getMustPay() {
        return mustPay;
    }

    public void setMustPay(Double mustPay) {
        this.mustPay = mustPay;
    }

    public Double getChangeMoney() {
        return changeMoney;
    }

    public void setChangeMoney(Double changeMoney) {
        this.changeMoney = changeMoney;
    }

    public Double getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(Double discountMoney){
        this.discountMoney = discountMoney;
    }

    public SysUser getCashier() {
        return cashier;
    }

    public void setCashier(SysUser cashier) {
        this.cashier = cashier;
    }

    public Double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public Integer getOverStatus() {
        return overStatus;
    }

    public void setOverStatus(Integer overStatus) {
        this.overStatus = overStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderCode='" + orderCode + '\'' +
                ", deskCode='" + deskCode + '\'' +
                ", cashier=" + cashier +
                ", member=" + member +
                ", totalCost=" + totalCost +
                ", totalPrice=" + totalPrice +
                ", totalProfit=" + totalProfit +
                ", actualPay=" + actualPay +
                ", mustPay=" + mustPay +
                ", changeMoney=" + changeMoney +
                ", discountMoney=" + discountMoney +
                ", peopleNum=" + peopleNum +
                ", payStatus=" + payStatus +
                ", finishStatus=" + finishStatus +
                ", overStatus=" + overStatus +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
