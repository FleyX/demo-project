package com.fanxb.sjdemo.serviceTest;

import com.fanxb.sjdemo.entity.Order;
import com.fanxb.sjdemo.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/22 15:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void addOrderTest() {
        Order order = new Order();
        order.setUId(12);
        order.setCreateTime(new Date());
        order.setTotalPrice(12);
        orderService.insertOne(order);
    }
}
