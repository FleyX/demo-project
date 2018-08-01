package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.User;

public interface UserMapper {
	//新增用户
	@Insert("insert into user(name,age,password) value(#{name},#{age},#{password})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public void insert(User user);

	//查找所有用户
	@Select("select * from user")
	public List<User> getAll();
	
	//根据id查找用户
	@Select("select * from user where id=#{id}")
	public User getById(int id);
	
	@Update("update user set name=#{name},age=#{age},password=#{password} where id=#{id}")
	public boolean update(User user);

	//根据id删除用户
	@Delete("delete from user where id=#{id}")
	public boolean deleteById(int id);
	
}
