package com.example.demo.service;

import com.example.demo.entity.Jurisdiction;
import com.example.demo.entity.User;
import com.example.demo.mapper.JurisdictionMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.security.authentication.MyGrantedAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-20
 */
@Component
public class SecurityUserService implements UserDetailsService {
    @Autowired
    private JurisdictionMapper jurisdictionMapper;
    @Autowired
    private UserMapper userMapper;
    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("登录用户id为：{}",username);
		int id = Integer.valueOf(username);
		User user = userMapper.getById(id);
		if(user==null) {
			log.info("登录用户id不存在：{}",username);
			throw new UsernameNotFoundException("用户名 "+username+"不存在");
		}
		//获取用户权限
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<Jurisdiction> jurisdictions = jurisdictionMapper.selectByUserId(id);
		for(Jurisdiction item : jurisdictions) {
//			GrantedAuthority authority = new SimpleGrantedAuthority(item.getPermission());
            GrantedAuthority authority = new MyGrantedAuthority(item.getMethod(),item.getUrl());
			authorities.add(authority);
		}
		user.setAuthorities(authorities);
		log.info("获取用户{}信息成功,权限为：{}",username,authorities);
		return user;
	}
}
