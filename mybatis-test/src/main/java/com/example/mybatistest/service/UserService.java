package com.example.mybatistest.service;

import com.example.mybatistest.dao.UserDao;
import com.example.mybatistest.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-30
 */
@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getByUserId(String id){
        return userDao.selectById(id);
    }
    //获取全部用户
    public List<User> getAll(){
        return userDao.selectAll();
    }
    //测试分页
    public PageInfo<User> getAll(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userDao.selectAll();
        System.out.println(users.size());
        PageInfo<User> result = new PageInfo<>(users);
        return result;
    }

    public int insert(User user){
        return userDao.insert(user);
    }

}
