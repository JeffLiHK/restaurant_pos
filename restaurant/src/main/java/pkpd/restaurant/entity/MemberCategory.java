package pkpd.restaurant.entity;

/**
 * Created with IDEA
 * author:LiuJing
 * Date:2018/10/1
 * Time:22:55
 * 
 */

public class MemberCategory extends BaseBean{
    /**
     * id
     */
    private  Integer mcId;
    /**
     * 
     */
    private  String mcName;
    /**
     * 
     */
    private String discount;
    /**
     * 
     */
    private Double amount;

    public Integer getMcId() {
        return mcId;
    }

    public void setMcId(Integer mcId) {
        this.mcId = mcId;
    }

    public String getMcName() {
        return mcName;
    }

    public void setMcName(String mcName) {
        this.mcName = mcName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
