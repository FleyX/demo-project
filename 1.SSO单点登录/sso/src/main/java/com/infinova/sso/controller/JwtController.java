package com.infinova.sso.controller;

import com.alibaba.fastjson.JSONArray;
import com.infinova.sso.entity.ReturnEntity;
import com.infinova.sso.entity.User;
import com.infinova.sso.service.JwtService;
import com.infinova.sso.util.HttpUtil;
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

    @PostMapping("/checkJwt")
    public ReturnEntity checkJwt(String token) {
        return ReturnEntity.successResult(service.checkJwt(token));
    }

    @GetMapping("/inValid")
    public ReturnEntity inValid() {
        String token = HttpUtil.getData(JwtService.JWT_KEY);
        service.inValid(token);
        return ReturnEntity.successResult(null);
    }
}
