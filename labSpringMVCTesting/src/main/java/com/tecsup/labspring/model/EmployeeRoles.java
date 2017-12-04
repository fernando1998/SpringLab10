package com.tecsup.labspring.model;

public class EmployeeRoles {

	private int employeeRoleId;
	private String login;
	private String role;
	
	
	
	
	public EmployeeRoles() {
		super();
	}
	
	
	public EmployeeRoles(int employeeRoleId, String login, String role) {
		super();
		this.employeeRoleId = employeeRoleId;
		this.login = login;
		this.role = role;
	}


	public int getEmployeeRoleId() {
		return employeeRoleId;
	}
	public void setEmployeeRoleId(int employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "EmployeeRoles [employeeRoleId=" + employeeRoleId + ", login=" + login + ", role=" + role + "]";
	}
	
	
	
	}
