package com.cg.myair.bean;

public class UserBean {
	 
	private String name;
	private String userName;
	private String password;
	private String mobileNumber;
	
	//No args Constructor
	public UserBean() {
		super();
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public UserBean(String name, String userName, String password,
			String mobileNumber) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "UserBean [name=" + name + ", userName=" + userName
				+ ", password=" + password + ", mobileNumber=" + mobileNumber
				+ "]";
	}

}