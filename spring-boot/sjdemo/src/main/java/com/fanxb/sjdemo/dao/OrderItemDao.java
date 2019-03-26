package com.fanxb.sjdemo.dao;

import com.fanxb.sjdemo.entity.OrderItem;

import java.util.List;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/22 16:25
 */
public interface OrderItemDao {
    /**
     * Description:
     *
     * @param order order
     * @author fanxb
     * @date 2019/3/25 14:12
     */
    void addOne(OrderItem orderItem);

    /**
     * Description:
     *
     * @param id id
     * @return java.util.List<com.fanxb.sjdemo.entity.OrderItem>
     * @author fanxb
     * @date 2019/3/25 14:12
     */
    List<OrderItem> getByOrderId(int id);

}
