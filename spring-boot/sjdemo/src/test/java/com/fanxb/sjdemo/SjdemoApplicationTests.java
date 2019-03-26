package com.fanxb.sjdemo;

import com.fanxb.sjdemo.dao.OrderDao;
import com.fanxb.sjdemo.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.logging.ConsoleHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SjdemoApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DataSource dataSource;

    @Autowired
    private OrderDao orderDao;

    @Test
    public void contextLoads() throws Exception {
        try (
                Connection conn = dataSource.getConnection();
                Statement statement = conn.createStatement();
        ) {
            statement.execute("insert into user(name,age) value('2012-12-12 12:12:12',1212)");
            statement.execute("select * from user");
        }
    }
}

