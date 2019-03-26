package com.fanxb.sjdemo.dao;

import com.fanxb.sjdemo.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/22 16:25
 */
public interface OrderDao {
    /**
     * Description:
     *
     * @param order order
     * @return long
     * @author fanxb
     * @date 2019/3/25 14:23
     */
    long addOne(Order order);

    /**
     * Description:
     *
     * @param orderId orderId
     * @param userId  userId
     * @return com.fanxb.sjdemo.entity.Order
     * @author fanxb
     * @date 2019/3/25 14:23
     */
    Order selectOne(@Param("orderId") long orderId, @Param("userId") int userId);

    /**
     * Description:
     *
     * @param id id
     * @return java.util.List<com.fanxb.sjdemo.entity.Order>
     * @author fanxb
     * @date 2019/3/25 14:24
     */
    List<Order> getOrderByUserId(int id);

}
