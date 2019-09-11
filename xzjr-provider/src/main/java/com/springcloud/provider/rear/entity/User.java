package com.springcloud.provider.rear.entity;

import java.io.Serializable;

/**
 * @author：xieshuai
 * @description： 用户信息
 * @date：2019/8/21 15:05
 */
public class User implements Serializable{

	private static final long serialVersionUID = -1690996122264514683L;
	/**
	 *  后台登录用户表
	 */
	private Integer id;

	/**
	 *  用户名
	 */
	private String username;

	/**
	 *  密码
	 */
	private String password;

	/**
	 *  有效状态
	 */
	private String status;

	/**
	 *  联系方式
	 */
	private String mobile;

	/**
	 *  性别
	 */
	private String sex;

	/**
	 *  邮箱
	 */
	private String email;

	/**
	 *  真实姓名
	 */
	private String trueName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", username='" + username + '\'' +
			", password='" + password + '\'' +
			", status='" + status + '\'' +
			", mobile='" + mobile + '\'' +
			", sex='" + sex + '\'' +
			", email='" + email + '\'' +
			", trueName='" + trueName + '\'' +
			'}';
	}

	public User() {
	}

	public User(Integer id, String username, String password, String status, String mobile, String sex, String email, String trueName) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.mobile = mobile;
		this.sex = sex;
		this.email = email;
		this.trueName = trueName;
	}
}
