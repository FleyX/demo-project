package com.fanxb.sjdemo.service;

import com.fanxb.sjdemo.dao.UserDao;
import com.fanxb.sjdemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/22 15:36
 */
@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao dao;

    public void addOne(String name, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        long id= dao.addOne(user);
        logger.info("插入id:{}", user.getuId());
    }

    public User getOne(int id){
        return dao.getOneById(id);
    }
}
