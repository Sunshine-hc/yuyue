package com.newer.yuyue.service;

import com.newer.yuyue.domain.UserInfo;
import com.newer.yuyue.mapper.UserInfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 登录
     * @param phone
     * @param pwd
     * @return
     */
    public UserInfo findByParam(String phone,String pwd){
        UserInfo userInfo = userInfoMapper.findByParam(phone,pwd);
        return userInfo;
    }

}
