package com.newer.yuyue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.newer.yuyue.mapper")
public class YuyueApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuyueApplication.class, args);
    }

}
