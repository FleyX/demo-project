package com.example.sysa.controller;

import com.example.sysa.entity.ReturnEntity;
import com.example.sysa.entity.UserContext;
import com.example.sysa.filter.LoginFilter;
import com.example.sysa.util.HttpClient;
import com.example.sysa.util.UserContextHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/1 14:08
 */
@RestController
public class Main {

    @Value("${sso_server}")
    private String serverHost;

    @RequestMapping("/test")
    public ReturnEntity test() {
        return new ReturnEntity(1, "通过验证", null);
    }


    @RequestMapping("/logout")
    public ReturnEntity logout() throws Exception {
        UserContext context = UserContextHolder.get();
        HttpClient.get(serverHost + "/clearToken?token=" + context.getToken());
        return null;
    }
}
