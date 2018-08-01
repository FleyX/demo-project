package com.example.demo.security;

import com.example.demo.error.ErrorCode;
import com.example.demo.util.JsonHelper;
import com.example.demo.util.Reply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("myAccessDeniedHandler")
public class MyAccessDeniedHandler implements AccessDeniedHandler{
	
	@Autowired
	private JsonHelper jsonHelper;

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

	    log.info("吴操作权限：{}",accessDeniedException.getMessage());
		response.setContentType("application/json;charset=UTF-8");
		ErrorCode code = ErrorCode.NO_PERMISSION;
		response.getWriter().write(jsonHelper.toJson(new Reply(code.getCode(),code.getMess())));
		
	}
	

}
