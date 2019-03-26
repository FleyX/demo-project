package com.fanxb.sjdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanxb.sjdemo.entity.User;
import com.fanxb.sjdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/25 14:25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PutMapping("")
    public long addUser(@RequestBody JSONObject obj){
        User user = obj.toJavaObject(User.class);
        return userService.addOne(user);
    }

    @GetMapping("test")
    public void testTransactional(){
        this.userService.testTransactional();
    }

}
