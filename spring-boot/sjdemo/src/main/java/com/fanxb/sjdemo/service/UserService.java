package com.fanxb.sjdemo.service;

import com.fanxb.sjdemo.dao.UserDao;
import com.fanxb.sjdemo.entity.User;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/22 15:36
 */
@Service
@Slf4j
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao dao;

    public long addOne(User user) {
        this.dao.addOne(user);
        return user.getUserId();
    }

    public User getOne(long id) {
        return dao.getOneById(id);
    }

    /**
     * 测试跨库事务
     */
    @ShardingTransactionType(TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    public void testTransactional() {
        User user1 = new User(123, "988", 12);
        logger.info("user1已经插入");
        logger.info("user1已经插入");
        this.dao.addOne(user1);
        User user2 = new User(124, "988", 12);
        this.dao.addOne(user2);
        this.dao.addOne(user2);
    }
}
