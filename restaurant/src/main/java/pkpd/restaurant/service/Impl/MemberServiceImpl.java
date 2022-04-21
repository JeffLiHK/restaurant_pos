package pkpd.restaurant.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import pkpd.restaurant.Enums.ResultEnum;
import pkpd.restaurant.dao.MemberCategoryDao;
import pkpd.restaurant.dao.MemberDao;
import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.Member;
import pkpd.restaurant.exception.CustomException;
import pkpd.restaurant.service.MemberService;
import pkpd.restaurant.utils.SplitIdsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberCategoryDao memberCategoryDao;

    /**
     * 
     * @param member
     */
    @Override
    public void update(Member member){
        Member findMember = memberDao.searchByPhone(member);
        if(findMember!=null){
            throw  new CustomException(ResultEnum.PHONE_IS_EXIST);
        }
        member.setModifyTime(new Date());
        int effect = memberDao.update(member);
    }

    /**
     * 
     * @param member
     */
    @Override
    public void addMember(Member member){
        Member findMember = memberDao.searchByMemberCode(member);
        if(findMember!=null){
            throw new CustomException(ResultEnum.USER_IS_EXIST);
        }
        findMember = memberDao.searchByPhone(member);
        if(findMember!=null){
            throw  new CustomException(ResultEnum.PHONE_IS_EXIST);
        }
        member.setCreateTime(new Date());
        memberDao.insert(member);
    }

    /**
     * 
     * @param pageInfo
     * @return
     */
    @Override
    public CustomPageInfo<Member> findPage(CustomPageInfo<Member> pageInfo) {
        //PageHelper
        Page page = PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        memberDao.findPage(pageInfo.getT());
        //,
        CustomPageInfo<Member> info = new CustomPageInfo<>(page);
        return info;
    }

    /**
     * memberId
     * @param member
     * @return
     */
    @Override
    public Member findMemberById(Member member) {
        List<Member> memberList = memberDao.findPage(member);
        return memberList.get(0);
    }

    /**
     * 
     * @param member
     * @return
     */
    @Override
    public Member findMemberByMemberCode(Member member) {
        return memberDao.searchByMemberCode(member);
    }

    /**
     * id
     * @param strIds
     */
    @Override
    public void deleteByIds(String strIds) {
       List<Long> idList =  SplitIdsUtil.splitStrIds(strIds);
       int effect = memberDao.deleteByIds(idList);
       if(effect<0){
           throw new CustomException(ResultEnum.DEL_DB_FAIL);
       }
    }
}
