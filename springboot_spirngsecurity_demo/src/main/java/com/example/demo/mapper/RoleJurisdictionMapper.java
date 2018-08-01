package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface RoleJurisdictionMapper {
	@Delete("delete from roleJurisdictionRelation where r_id=#{id}")
	public void deleteByRoleId(int id);
	
	@Insert("insert into roleJurisdictionRelation(r_id,j_id) value(#{roleId},#{jId})")
	public void insert(int roleId,int jId);
}
