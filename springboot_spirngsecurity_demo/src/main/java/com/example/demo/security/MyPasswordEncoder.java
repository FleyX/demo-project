package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.util.StringUtil;
import org.springframework.stereotype.Component;

/**
 * @author fxb 实现PasswordEncoder接口，自定义加密算法，自定义密码判断
 * 
 */
@Component
public class MyPasswordEncoder implements PasswordEncoder {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	//密码是否匹配
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String encodeStr = StringUtil.StringToMD5(rawPassword.toString());
		log.info("raw:{},encoded:{}", rawPassword.toString(), encodedPassword);
		return encodedPassword.equals(encodeStr);
	}
}
