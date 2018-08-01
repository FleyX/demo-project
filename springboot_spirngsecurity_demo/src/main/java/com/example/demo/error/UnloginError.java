package com.example.demo.error;

public class UnloginError extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private int errorCode;

	public UnloginError() {
		super("未登录");
		this.errorCode=ErrorCode.UNLOGIN.getCode();
		
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
