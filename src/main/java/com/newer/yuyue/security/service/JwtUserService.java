package com.newer.yuyue.security.service;

import com.newer.yuyue.domain.UserInfo;
import com.newer.yuyue.mapper.UserInfoMapper;
import com.newer.yuyue.security.domain.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class JwtUserService implements UserDetailsService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoMapper.findByUsername(username);

        if (Objects.isNull(userInfo)){
            throw new UsernameNotFoundException("用户不存在！");
        }
        return JwtUserFactory.create(userInfo);
    }


}
