package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.util.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//获取用户列表
	@GetMapping("/user")
	public Object getAllUser(){
		return new Reply(userService.getAll());
	}
	
	@GetMapping("/user/{userId}")
	public Object getOne(@PathVariable int userId){
		return new Reply(userService.getOne(userId));
	}

	@GetMapping("/user/{userId}/12")
    public Object getTwo(@PathVariable int userId){
	    return new Reply(userService.getOne(userId));
    }

    @PostMapping("/user")
    public void insert(){
	    userService.insert();
    }
}
