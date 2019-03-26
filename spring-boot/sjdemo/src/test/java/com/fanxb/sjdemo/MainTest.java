package com.fanxb.sjdemo;

import com.fanxb.sjdemo.dao.*;
import com.fanxb.sjdemo.entity.*;
import com.fanxb.sjdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MainTest {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private DictionaryDao dictionaryDao;

    @Autowired
    private OtherTableDao otherTableDao;

    @Autowired
    private UserService userService;

    //固定用户id
    private long userId = 8009821;

    //固定订单金额
    private int orderPrice = 300;

    /**
     * Description: 分库分表插入数据测试
     *
     * @return void
     * @author fanxb
     * @date 2019/3/26 16:35
     */
    @Test
    public void insert1() throws Exception {
        //插入用户
        User user = new User();
        user.setUserId(userId);
        user.setName("test");
        user.setAge(12);
        this.userDao.addOne(user);
        log.info("插入用户id：{}", user.getUserId());
        //插入订单
        Order order = new Order();
        order.setUserId(user.getUserId());
        order.setTotalPrice(orderPrice);
        order.setCreateTime(new Date());
        this.orderDao.addOne(order);
        log.info("插入订单id:{}", order.getOrderId());
        //插入订单详细项
        OrderItem item = new OrderItem();
        item.setOrderId(order.getOrderId());
        item.setName("apple");
        item.setPrice(10);
        //要根据用户id判断属于哪个库
        item.setUserId(user.getUserId());
        this.orderItemDao.addOne(item);
        log.info("插入订单项id：{}", item.getOrderItemId());
    }

    /**
     * Description:查询用户订单,能根据用户id确定表，不会出现笛卡儿积
     *
     * @return void
     * @author fanxb
     * @date 2019/3/26 16:52
     */
    @Test
    public void selectOrder() {
        List<Order> orders = this.orderDao.getOrderByUserId(userId);
        log.info("查询用户订单结果为：{}", Arrays.toString(orders.toArray()));
    }

    /**
     * Description:根据订单金额连表查询订单项,会产生笛卡儿积查询，没有关键字确定库或者表
     *
     * @return void
     * @author fanxb
     * @date 2019/3/26 16:54
     */
    @Test
    public void selectOrderItem() {
        List<OrderItem> orderItems = this.orderItemDao.getOrderItemByPrice(orderPrice);
        log.info("查询到结果为：{}", Arrays.toString(orderItems.toArray()));
    }

    /**
     * Description: 公共表插入测试
     *
     * @return void
     * @author fanxb
     * @date 2019/3/26 16:59
     */
    @Test
    public void insertDictionary() {
        Dictionary dictionary = new Dictionary();
        dictionary.setName("key");
        dictionary.setValue("value");
        this.dictionaryDao.addOne(dictionary);
        log.info("字典表插入id为：{}", dictionary.getDictionaryId());
    }

    /**
     * Description: 其他表插入测试
     *
     * @author fanxb
     * @date 2019/3/26 17:00
     */
    @Test
    public void insertOtherTable() {
        OtherTable table = new OtherTable();
        table.setName("test");
        this.otherTableDao.addOne(table);
        log.info("其它表插入id为：{}", table.getId());
    }

    /**
     * Description:其它表查询测试，会报错
     *
     * @return void
     * @author fanxb
     * @date 2019/3/26 17:02
     */
    @Test
    public void selectOtherTable() {
        this.otherTableDao.getAll();
    }

    /**
     * Description: 事务测试
     *
     * @author fanxb
     * @date 2019/3/26 17:03
     */
    @Test
    public void transTest() {
        this.userService.testTransactional();
    }

}

