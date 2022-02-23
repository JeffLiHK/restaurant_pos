package pkpd.restaurant.service.Impl;

import pkpd.restaurant.entity.CustomPageInfo;
import pkpd.restaurant.entity.SysRole;
import pkpd.restaurant.entity.SysUser;
import pkpd.restaurant.entity.request.UserRequest;
import pkpd.restaurant.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceImplTest {
    @Autowired
    private SysUserService sysUserService;
    @Test
    public void findAll() {
        System.out.println(sysUserService.findAll());
    }
    @Test
    public void findPage(){
        SysUser sysUser = new SysUser();
        SysRole sysRole = new SysRole();
        /*sysRole.setRoleId(1L);
        sysUser.setRole(sysRole);
        sysUser.setGender("男");*/
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        sysUser.setBirthday(date);
        UserRequest userRequest = new UserRequest();
        userRequest.setPageNum(1);
        userRequest.setPageSize(2);
        CustomPageInfo<SysUser> users = sysUserService.findPage(userRequest);
    }
}