package com.example.demo.error;

public enum ErrorCode {
	OK(0,"正常"),
	UNLOGIN(1,"未登录"),
	NO_PERMISSION(2,"无操作权限"),
	SERVICE_ERROR(3,"服务发生错误"),
	BAD_REQUEST(4,"请求无法执行"),
	HAD_LOGIN(5,"已登录"),
	WRONG_LOGIN_INFO(6,"账号密码错误"),
	UNKONWN_ERROR(555,"其他错误");
	
	private final int code;
	private final String mess;
	private ErrorCode(int code,String mess) {
		this.code = code;
		this.mess = mess;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMess() {
		return mess;
	}
}
