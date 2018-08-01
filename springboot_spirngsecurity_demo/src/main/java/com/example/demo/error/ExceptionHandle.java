package com.example.demo.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.util.Reply;

@RestControllerAdvice
public class ExceptionHandle {
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

	// 运行时异常捕捉
	@ExceptionHandler(RuntimeException.class)
	public Object handleRuntionException(RuntimeException e) {
		if (e instanceof HttpMessageConversionException) {
			log.error("bad request:{},{}", e.getMessage(), e);
			return new Reply(ErrorCode.BAD_REQUEST.getCode(), "参数无法理解");
		}
		if (e instanceof ServiceError) {
			log.error("业务错误:{},{}", e.getMessage(), e);
			return new Reply(((ServiceError) e).getErrorCode(), e.getMessage());
		}
		if (e instanceof RuntimeException) {
			return new Reply(ErrorCode.SERVICE_ERROR.getCode(),e.getMessage() );
		}
		log.error("其他错误：{}，{}", e.getMessage(), e);
		return new Reply(ErrorCode.UNKONWN_ERROR.getCode(), "未知错误");
	}

	// 全局异常捕捉
	@ExceptionHandler(Exception.class)
	public Object handleException(Exception e) {
		log.error("未处理异常:{}\n{}", e.getMessage(), e);
		return new Reply(ErrorCode.UNKONWN_ERROR.getCode(), "未处理异常");
	}
}
