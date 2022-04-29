package pkpd.restaurant.service;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Member;

/**
 * Created with IDEA
 * author:Jeff Li
 * Date:2020/10/2
 * Time:14:58
 *
 * 
 */

public interface MemberService {
    /**
     * 
     * @param member
     * @return
     */
    void update(Member member);

    /**
     * 
     * @param member
     * @return
     */
    void addMember(Member member);

    /**
     * ，
     * @param pageInfo
     * @return
     */
    CustomPageInfo<Member> findPage(CustomPageInfo<Member> pageInfo);

    /**
     * memberId
     * @param member
     * @return
     */
    Member findMemberById(Member member);

    /**
     * 
     * @param member
     * @return
     */
    Member findMemberByMemberCode(Member member);

    /**
     *id
     */
    void deleteByIds(String ids);

}
