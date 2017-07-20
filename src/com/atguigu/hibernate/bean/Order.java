package com.atguigu.hibernate.bean;

public class Order {

	private Integer orderId ; 
	private String orderName ; 
	
	private User user ;

	public Order(Integer orderId, String orderName, User user) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.user = user;
	}

	public Order() {
		super();
	}

	public Order(Integer orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", user=" + user + "]";
	} 
	
	
}
