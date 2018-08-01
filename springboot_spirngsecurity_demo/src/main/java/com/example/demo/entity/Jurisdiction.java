package com.example.demo.entity;

public class Jurisdiction {
	private int id;
	private String permission;
	private String description;
	private String url;
	private String method;
	
	public Jurisdiction() {}

	public Jurisdiction(int id, String permission, String description, String url, String method) {
		this.id = id;
		this.permission = permission;
		this.description = description;
		this.url = url;
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
