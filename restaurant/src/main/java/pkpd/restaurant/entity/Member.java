package pkpd.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * Created with IDEA
 * author:LiuJing
 * Date:2018/10/1
 * Time:22:41
 *
 */
public class Member extends BaseBean {
    /**
     * id
     */
    private Long memberId;
    /**
     *
     */
    private String memberCode;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String gender;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")//json
    @DateTimeFormat(pattern = "yyyy-MM-dd")//Stringdate
    private Date birthday;
    /**
     *
     */
    private String phone;

    /**
     *
     */
    private MemberCategory memberCategory;
    /**
     *
     */
    private Double totalMoney;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public MemberCategory getMemberCategory() {
        return memberCategory;
    }

    public void setMemberCategory(MemberCategory memberCategory) {
        this.memberCategory = memberCategory;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberCode='" + memberCode + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", memberCategory=" + memberCategory +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
