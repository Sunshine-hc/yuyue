package com.newer.yuyue.controller;

import com.newer.yuyue.domain.UserInfo;
import com.newer.yuyue.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 登录
     * @param phone
     * @param pwd
     * @return
     */
    @GetMapping("/login")
    public ResponseEntity<?> findByParam(String phone, String pwd){
        UserInfo userInfo = userInfoService.findByParam(phone,pwd);
        Map<String,Object> result = new HashMap<>();

        if(Objects.isNull(userInfo)){
            result.put("msg","用户名或密码错误！");
        }else{
            //登录成功将用户信息保存到session
            result.put("loginer",userInfo);
        }

        return ResponseEntity.ok(result);
    }

    /**
     * 注册
     * @return
     */
    @GetMapping("/zhuce")
    public ResponseEntity<?> zhuce(){

        return ResponseEntity.ok(0);
    }
}
