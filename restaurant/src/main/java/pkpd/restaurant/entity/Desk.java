package pkpd.restaurant.entity;

import javax.validation.constraints.NotNull;

/**
 * Created with IDEA
 * author:Jeff Li
 * Date:2020/10/1
 * Time:22:33
 */

public class Desk extends BaseBean{
    /**
     * id
     */
    private Integer deskId;
    /**
     * 
     */
    @NotNull(message = "Desk ID needed")
    private String deskCode;
    /**
     * 
     */
    private Integer peopleCount;
    /**
     * (0，1,2)
     */
    private Integer idleStatus;

    public Integer getDeskId() {
        return deskId;
    }

    public void setDeskId(Integer deskId) {
        this.deskId = deskId;
    }

    public String getDeskCode() {
        return deskCode;
    }

    public void setDeskCode(String deskCode) {
        this.deskCode = deskCode;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getIdleStatus() {
        return idleStatus;
    }

    public void setIdleStatus(Integer idleStatus) {
        this.idleStatus = idleStatus;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "deskId=" + deskId +
                ", deskCode='" + deskCode + '\'' +
                ", peopleCount=" + peopleCount +
                ", idleStatus=" + idleStatus +
                '}';
    }
}
