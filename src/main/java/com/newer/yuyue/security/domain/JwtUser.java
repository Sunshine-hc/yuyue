package com.newer.yuyue.security.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * 为安全框架服务的用户实体类
 */
public class JwtUser implements UserDetails {

    private final Integer userid;//用户id
    private final String phone;//电话（登录账号）
    private final String pwd;//密码
    private final String nickname;//昵称
    private final String realname;//真实姓名
    private final String uidcard;//身份证号码
    private final String email;//邮箱
    private final String uimage;//图片（头像）
    private final Double balance;//余额
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastPasswordResetDate;//最后修改密码时间
    private final String by1;//备用
    private final String by2;
    private final Collection<? extends GrantedAuthority> authorities;

    //带参构造方法


    public JwtUser(Integer userid, String phone, String pwd, String nickname, String realname, String uidcard, String email, String uimage, Double balance, Date lastPasswordResetDate, String by1, String by2, Collection<? extends GrantedAuthority> authorities) {
        this.userid = userid;
        this.phone = phone;
        this.pwd = pwd;
        this.nickname = nickname;
        this.realname = realname;
        this.uidcard = uidcard;
        this.email = email;
        this.uimage = uimage;
        this.balance = balance;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.by1 = by1;
        this.by2 = by2;
        this.authorities = authorities;
    }

    public Integer getUserid() {
        return userid;
    }

    public String getPhone() {
        return phone;
    }

    public String getPwd() {
        return pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public String getRealname() {
        return realname;
    }

    public String getUidcard() {
        return uidcard;
    }

    public String getEmail() {
        return email;
    }

    public String getUimage() {
        return uimage;
    }

    public Double getBalance() {
        return balance;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public String getBy2() {
        return by2;
    }

    public String getBy1() {
        return by1;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public String getUsername() {
        return this.phone;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
