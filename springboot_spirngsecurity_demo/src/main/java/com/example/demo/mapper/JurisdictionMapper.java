package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Jurisdiction;

public interface JurisdictionMapper {

	@Select("select * from Jurisdiction")
	public List<Jurisdiction> selectAllPermission();


	@Insert("insert into jurisdiction(permission,description) value(#{permission},#{description})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public void addOne(Jurisdiction jurisdiction);

	@Delete("delete from jurisdiction where id=#{id}")
	public boolean deleteOne(int id);

	@Update("update jurisdiction set permission=#{permission},description = #{description} where id=#{id}")
	public boolean update(Jurisdiction jurisdiction);
	
	//查找某角色所有权限
	@Select("SELECT b.* FROM RoleJurisdictionRelation a INNER JOIN jurisdiction b ON a.j_id = b.id WHERE a.r_id =#{id}")
	public List<Jurisdiction> selectByRoleId(int id);
	
	//查找某用户所有权限
	@Select("SELECT c.* FROM UserRoleRelation a INNER JOIN RoleJurisdictionRelation b ON a.r_id = b.r_id INNER JOIN Jurisdiction c ON b.j_id = c.id WHERE a.u_id =#{id}")
	public List<Jurisdiction> selectByUserId(int id);
}
