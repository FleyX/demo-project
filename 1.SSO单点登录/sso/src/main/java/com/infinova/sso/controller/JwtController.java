package com.infinova.sso.controller;

import com.infinova.sso.entity.ReturnEntity;
import com.infinova.sso.entity.User;
import com.infinova.sso.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/4 18:16
 */
@RestController
public class JwtController {

    private JwtService service;

    @Autowired
    public JwtController(JwtService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ReturnEntity login(@RequestBody User user) {
        String token = service.login(user);
        return ReturnEntity.successResult(token);
    }

    @GetMapping("/checkJwt")
    public ReturnEntity checkJwt(String token) {
        return ReturnEntity.successResult(service.checkJwt(token));
    }

    @GetMapping("/refreshJwt")
    public ReturnEntity refreshJwt(String token){
        return ReturnEntity.successResult(service.refreshJwt(token));
    }

    @GetMapping("/inValid")
    public ReturnEntity inValid(String token) {
        service.inValid(token);
        return ReturnEntity.successResult(null);
    }
}
