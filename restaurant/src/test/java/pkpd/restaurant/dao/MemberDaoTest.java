package pkpd.restaurant.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberDaoTest {
    @Autowired
    private MemberDao memberDao;
    @Test
    public void findPage() {
    }

    /*@Test
    public void searchByPhone(){
        Member member = new Member();
        member.setMemberId(1L);
        member.setPhone("57359824");
       // System.out.println(memberDao.searchByPhone(member).toString());
    }

    @Test
    public void searchByMemberCode() {
        Member member = new Member();
        member.setMemberCode("92026469");
        //System.out.println(memberDao.searchByMemberCode(member).toString());
    }

    @Test
    public void insert() {
        Member member = new Member();

    }

    @Test
    public void deleteByIds() {
    }

    @Test
    public void update() {
    }*/
}