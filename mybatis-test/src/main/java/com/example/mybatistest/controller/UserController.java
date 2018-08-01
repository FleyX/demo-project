package com.example.mybatistest.controller;

import com.example.mybatistest.entity.User;
import com.example.mybatistest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-30
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getByUserId(userId);
    }

    @GetMapping("/user")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/user/page/{pageNum}")
    public Object getPage(@PathVariable int pageNum,
                          @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize){
        return userService.getAll(pageNum,pageSize);
    }

    @PostMapping("/user")
    public Object addOne(User user){
        userService.insert(user);
        return user;
    }

}
