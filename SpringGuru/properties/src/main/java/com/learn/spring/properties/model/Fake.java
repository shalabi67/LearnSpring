package com.learn.spring.properties.model;

public class Fake {
	private String userName;
	private String password;
	private String url;

	public Fake(String userName, String password, String url) {
		this.userName = userName;
		this.password = password;
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}
}
