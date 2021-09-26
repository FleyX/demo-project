package com.fanxb.exceptiontest.controller;

import com.fanxb.exceptiontest.entity.Result;
import com.fanxb.exceptiontest.entity.exception.BaseException;
import com.fanxb.exceptiontest.entity.exception.CustomBusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanxb
 * @date 2021-09-24-下午4:46
 */
@RestController
public class TestController {

    @GetMapping("/test1")
    public Result test1() {
        throw new BaseException("我是test1", null);
    }

    @GetMapping("/test2")
    public Result test2() {
        throw new CustomBusinessException("我是test2", null);
    }

    @GetMapping("/test3")
    public Result test3() {
        throw new RuntimeException("我是test2");
    }
}
