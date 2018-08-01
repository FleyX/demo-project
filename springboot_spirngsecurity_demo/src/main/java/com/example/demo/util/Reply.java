package com.example.demo.util;

import com.example.demo.error.ErrorCode;

public class Reply {
	private int status;
	private String info;
	private Object data;

	public Reply() {
		System.out.println("reply默认构造函数");
		ErrorCode OK = ErrorCode.OK;
		this.status = OK.getCode();
		this.info = OK.getMess();
	}

	public Reply(int status, String info, Object data) {
		super();
		this.status = status;
		this.info = info;
		this.data = data;
	}

	public Reply(int status, String info) {
		this.status = status;
		this.info = info;
	}

	public Reply(int status) {
		this.status = status;
		this.info = "";
	}

	public Reply(String info) {
		this.status = ErrorCode.OK.getCode();
		this.info = info;
	}

	public Reply(String info, Object o) {
		this.status = ErrorCode.OK.getCode();
		this.info = info;
		this.data = o;
	}

	public Reply(Object o) {
		this.status = ErrorCode.OK.getCode();
		this.info = ErrorCode.OK.getMess();
		this.data = o;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
