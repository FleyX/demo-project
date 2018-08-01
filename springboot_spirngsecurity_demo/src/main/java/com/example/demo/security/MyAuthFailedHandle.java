package com.example.demo.security;

import com.example.demo.error.ErrorCode;
import com.example.demo.util.JsonHelper;
import com.example.demo.util.Reply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("myAuthFailedHandle")
public class MyAuthFailedHandle extends SimpleUrlAuthenticationFailureHandler{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JsonHelper jsonHelper;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setContentType("application/json;charset=UTF-8");
		ErrorCode code = ErrorCode.WRONG_LOGIN_INFO;
		response.getWriter().write(jsonHelper.toJson(new Reply(code.getCode(),code.getMess()+"asdf")));
	}
}
