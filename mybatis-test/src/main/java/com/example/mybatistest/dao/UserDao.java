package com.example.mybatistest.dao;

import com.example.mybatistest.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-30
 */
public interface UserDao {
    //插入用户
    @Insert("insert into user(name,age,password) value(#{name},#{age},#{password})")
    @Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
    int insert(User user);
    //根据id查询
    @Select("select * from user where id=#{id}")
    User selectById(String id);
    //查询所有
    @Select("select * from user")
    List<User> selectAll();
}
