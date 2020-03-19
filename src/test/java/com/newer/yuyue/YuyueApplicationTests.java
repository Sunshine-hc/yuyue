package com.newer.yuyue;

import com.newer.yuyue.domain.UserInfo;
import com.newer.yuyue.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class YuyueApplicationTests {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
    }

    @Test
    public void Test1(){
        UserInfo userInfo = userInfoMapper.findByUsername("15099999999");
        System.out.println("realname:" + userInfo.getRealname());
    }

    @Test
    /**
     * 密码加密
     */
    public void Test2(){
        String pwd = passwordEncoder.encode("123456");
        System.out.println(pwd.length());
        int i = userInfoMapper.changepwd(pwd,2);
        System.out.println(i);
    }
}
