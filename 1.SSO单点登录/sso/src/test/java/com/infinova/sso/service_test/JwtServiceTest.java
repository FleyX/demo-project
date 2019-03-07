package com.infinova.sso.service_test;

import com.infinova.sso.entity.User;
import com.infinova.sso.service.JwtService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.DatatypeConverter;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/5 8:57
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    @Test
    public void loginTest() throws Exception {
        User user = new User();
        user.setLoginId("admin");
        user.setPassword(DatatypeConverter.printBase64Binary("manage".getBytes("utf-8")));
        String token = jwtService.login(user);
        Assert.assertTrue(token != null && token.length() > 0);
    }

}
