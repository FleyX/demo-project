package com.fanxb.exceptiontest.controller;

import com.fanxb.exceptiontest.entity.Result;
import com.fanxb.exceptiontest.entity.consistant.Insert;
import com.fanxb.exceptiontest.entity.consistant.Update;
import com.fanxb.exceptiontest.entity.exception.BaseException;
import com.fanxb.exceptiontest.entity.exception.CustomBusinessException;
import com.fanxb.exceptiontest.entity.vo.TestBody;
import com.fanxb.exceptiontest.entity.vo.TestBody2;
import com.fanxb.exceptiontest.entity.vo.TestBody3;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author fanxb
 * @date 2021-09-24-下午4:46
 */
@RestController
@Validated
public class TestController {

    /**
     * url参数校验
     */
    @GetMapping("/test1")
    public Result test1(@NotBlank @RequestParam String param1, @Range(max = 100, min = 10) @RequestParam int param2) {
        return null;
    }

    /**
     * 表单校验
     */
    @PostMapping("/test2")
    public Result test2(@Valid @RequestBody TestBody body) {
        return null;
    }

    /**
     * 嵌套校验
     */
    @PostMapping("/test3")
    public Result test3(@Valid @RequestBody TestBody2 testBody2) {
        throw new RuntimeException("我是test2");
    }

    /**
     * 分组校验1
     */
    @PostMapping("/test4")
    public Result test4(@Validated({Update.class}) @RequestBody TestBody3 testBody) {
        return null;
    }

    /**
     * 分组校验2
     */
    @PostMapping("/test5")
    public Result test5(@Validated({Insert.class}) @RequestBody TestBody3 testBody) {
        return null;
    }

}
