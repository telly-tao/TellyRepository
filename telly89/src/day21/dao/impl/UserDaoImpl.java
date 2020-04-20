package day21.dao.impl;

import java.awt.Label;

import day21.dao.IUserDao;

public class UserDaoImpl implements IUserDao {
	private String username="admin";
	private String password="1234";

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

}
