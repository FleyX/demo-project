package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Role;

public interface RoleMapper {

	@Select("select * from role")
	public List<Role> selectAllRole();

	@Select("SELECT b.* from UserRoleRelation a INNER JOIN Role b on a.r_id = b.id where a.u_id = #{userId}")
	public List<Role> selectByUserId(int userId);

	@Insert("insert into role(name) value(#{name})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	public void addOne(Role role);

	@Delete("delete from role where id=#{id}")
	public boolean deleteOne(int id);

	@Update("update role set name=#{name} where id=#{id}")
	public boolean updateName(int id, String name);
}
