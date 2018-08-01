package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface UserRoleMapper {
	@Delete("delete from userRoleRelation where u_id=#{id}")
	public void deleteByUserId(int id);
	
	@Insert("insert into userRoleRelation(u_id,r_id) value(#{userId},#{roleId})")
	public void insert(int userId,int roleId);
	
	//根据角色名给用户分配角色
	@Insert("insert into userrolerelation select #{userId},id from role where name=#{roleName}")
	public void insertByRoleName(int userId,String roleName);
}
