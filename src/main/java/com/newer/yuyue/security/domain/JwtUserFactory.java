package com.newer.yuyue.security.domain;

import com.newer.yuyue.domain.Authority;
import com.newer.yuyue.domain.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    public static JwtUser create(UserInfo userInfo){
        return new JwtUser(
                userInfo.getUserid(),
                userInfo.getPhone(),
                userInfo.getPwd(),
                userInfo.getNickname(),
                userInfo.getRealname(),
                userInfo.getUidcard(),
                userInfo.getEmail(),
                userInfo.getUimage(),
                userInfo.getBalance(),
                userInfo.getBy1(),
                userInfo.getBy2(),
                mapToAuthority(userInfo.getAuthorities())
        );
    }

    /**
     * 将用户自定义用户对象的角色集合转换成安全框架管理的角色集合
     * @param list
     * @return
     */
    private static Collection<? extends GrantedAuthority> mapToAuthority(List<Authority> list){
        //集合的流式操作
        return list.stream().map(authority -> new SimpleGrantedAuthority(authority.getName().name())).collect(Collectors.toList());
    }
}
