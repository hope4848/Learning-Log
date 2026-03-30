package com.study.login;

public class User {
	private String id;
	private String password;
	private String name;
	
	public User(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	public String getId() {return id;}
	public String getName() {return name;}
	public boolean authenticate(String inputPw) {
		return this.password.equals(inputPw);
	}
}