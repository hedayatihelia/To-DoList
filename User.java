package com.mycompany.todolist;

public class User {

	private String username;
	private String password;
	
	public User (String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	public String getusername() {
		return username;
	}
	
	public String getpassword() {
		return password;
	}
	
	public void setusername(String newusername) {
		username=newusername;
	}
	
	public void setpassword(String newpassword) {
		password=newpassword;
	}
}
