package com.carl.app.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private Integer id;
	private String userName;
	private String userPassword;
	private Date birthday;
	private String phone;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User() {
		
	}
	//Contain parameter
	public User(Integer id, String userName, String userPassword, 
			Date birthday, String phone, String email) {
		this.id=id;
		this.userName=userName;
		this.userPassword=userPassword;
		this.birthday=birthday;
		this.phone=phone;
		this.email=email;
	}
}
