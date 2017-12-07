package com.cg.bean;

public class UserData {
	private int userId;
	private String name;
	private String city;
	private String branch;
	
	
	
	public UserData( String name, String city, String branch,int userId) {
		super();
		this.userId = userId;
		this.name = name;
		this.city = city;
		this.branch = branch;
	}
	public String getName() {
		return name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public UserData(String name, String city, String branch) {
		super();
		this.name = name;
		this.city = city;
		this.branch = branch;
	}
	
	
}
