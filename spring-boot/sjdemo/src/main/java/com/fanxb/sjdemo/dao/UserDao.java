package com.fanxb.sjdemo.dao;

import com.fanxb.sjdemo.entity.User;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/22 15:29
 */
public interface UserDao  {
    /**
     * Description:
     *
     * @author fanxb
     * @date 2019/3/25 14:22
     * @param user user
     */
    void addOne(User user);

    /**
     * Description:
     *
     * @author fanxb
     * @date 2019/3/25 14:22
     * @param id id
     * @return com.fanxb.sjdemo.entity.User
     */
    User getOneById(long id);
}
