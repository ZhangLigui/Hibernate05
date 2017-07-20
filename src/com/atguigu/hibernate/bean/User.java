package com.atguigu.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer userId ;
	private String userName ;
	private Set<Order> orders = new HashSet<Order>() ;
	
	public User(Integer userId, String userName, Set<Order> orders) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.orders = orders;
	}

	
	
	public User(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}



	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName +  "]";
	}
	
	
}
