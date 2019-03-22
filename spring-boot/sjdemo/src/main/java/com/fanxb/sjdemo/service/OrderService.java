package com.fanxb.sjdemo.service;

import com.fanxb.sjdemo.dao.OrderDao;
import com.fanxb.sjdemo.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/22 16:44
 */
@Service
public class OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderDao orderDao;

    public void insertOne(Order order) {
        long id = orderDao.addOne(order);
        logger.info("订单插入id：{}", order.getOrderId());
    }
}
