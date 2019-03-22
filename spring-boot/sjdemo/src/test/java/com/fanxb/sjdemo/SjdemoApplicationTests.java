package com.fanxb.sjdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SjdemoApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DataSource dataSource;

    @Test
    public void contextLoads() throws Exception {
        String sql = "SELECT i.* FROM order o JOIN order_item i ON o.orderId=i.orderId WHERE o.uId=? AND o.orderId=?";
        try (
                Connection conn = dataSource.getConnection();
                Statement statement = conn.createStatement();
        ) {
            Boolean res = statement.execute("insert into user(name,age) value('2012-12-12 12:12:12',1212)");
            logger.info(res.toString());
        }
    }
}

