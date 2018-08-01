package com.example.demo.error;

public class ServiceError extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	
	public ServiceError(String message) {
		super(message);
		this.errorCode = ErrorCode.SERVICE_ERROR.getCode();
	}
	
	public ServiceError(int code,String message) {
		super(message);
		this.errorCode = code;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
}
