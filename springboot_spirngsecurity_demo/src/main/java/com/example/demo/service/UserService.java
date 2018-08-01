package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.security.authentication.MyGrantedAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Jurisdiction;
import com.example.demo.entity.User;
import com.example.demo.mapper.JurisdictionMapper;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.util.StringUtil;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JurisdictionMapper jurisdictionMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	//默认分配guest角色
	public void register(User user) {
		user.setPassword(StringUtil.StringToMD5(user.getPassword()));
		log.info(user.toString());
		userMapper.insert(user);
		userRoleMapper.insertByRoleName(user.getId(), "guest");
	}
	
	//获取所有用户
	public List<User> getAll(){
		return userMapper.getAll();
	}

	public User getOne(int id){
	    User user = userMapper.getById(id);
	    return user;
    }

    //插入用户
    @Transactional
    public void  insert(){
	    User user = new User(100,"123456","fxb",(short)12);
	    userMapper.insert(user);
	    user.setAge((short)1000);
	    userMapper.insert(user);
	    log.info("插入用户完毕");
    }

}
