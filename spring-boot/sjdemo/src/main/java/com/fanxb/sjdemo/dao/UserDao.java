package com.fanxb.sjdemo.dao;

import com.fanxb.sjdemo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/22 15:29
 */
public interface UserDao  {
    long addOne(User user);

    User getOneById(int id);
}
