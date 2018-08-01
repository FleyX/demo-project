package com.example.demo.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.demo.util.JsonHelper;
import com.example.demo.util.Reply;

@Component("myAuthSuccessHandle")
public class MyAuthSuccessHandle implements AuthenticationSuccessHandler{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JsonHelper jsonHelper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(jsonHelper.toJson(new Reply("登录成功")));
	}
	
	

}
