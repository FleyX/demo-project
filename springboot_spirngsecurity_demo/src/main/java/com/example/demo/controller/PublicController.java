package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Reply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

	@Autowired
	private UserService userService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	//注册账号
	@PostMapping("/public/register")
	public Reply register(User user) {
		userService.register(user);
		return new Reply("注册成功");
	}

//	//未登录提示错误
//	@GetMapping("/public/unlogin")
//	public Reply unLoginError() {
//		ErrorCode code= ErrorCode.UNLOGIN;
//		return new Reply(code.getCode(),code.getMess());
//	}
}
