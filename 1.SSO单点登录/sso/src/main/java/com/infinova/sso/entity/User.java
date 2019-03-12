package com.infinova.sso.entity;

import java.io.Serializable;

/**
 * 类功能简述： 类功能详述：
 *
 * @author fanxb
 * @date 2019/2/28 18:34
 */
public class User implements Serializable {
	private String name;
	private String password;

	public User() {

	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
