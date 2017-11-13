package com.jiayidai.assess.entity;

public class Emp {

	private int userId;
	private String username;
	private String password;
	private int roleId;
	private int deptId;

	public Emp() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
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

	@Override
	public String toString() {
		return "Emp [userId=" + userId + ", username=" + username + ", password=" + password + ", roleId=" + roleId
				+ ", deptId=" + deptId + "]";
	}


}
