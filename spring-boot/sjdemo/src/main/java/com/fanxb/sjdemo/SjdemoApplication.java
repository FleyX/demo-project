package com.fanxb.sjdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.fanxb.sjdemo.dao")
public class SjdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SjdemoApplication.class, args);
    }

}
