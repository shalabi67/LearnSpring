package com.learn.spring.properties.model;

public class JmsFake {
	private String userName;
	private String password;
	private String url;

	public JmsFake(String userName, String password, String url) {
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
