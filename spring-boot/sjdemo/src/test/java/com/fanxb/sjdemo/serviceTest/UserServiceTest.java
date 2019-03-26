package com.fanxb.sjdemo.serviceTest;

import com.fanxb.sjdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/22 15:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void addUserTest(){
    }

    @Test
    public void getOneTest(){
        logger.info(userService.getOne(1).toString());
    }
}
