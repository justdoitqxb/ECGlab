package com.busycoder.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
    private String userName;
    private String password;
    
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
