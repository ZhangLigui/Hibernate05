package com.atguigu.hibernate.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.hibernate.bean.Order;
import com.atguigu.hibernate.bean.User;

public class HibernateTest {
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	@Test
	public void test08(){
		List<Order> list = session.createQuery("From Order").list() ;
		for (Order order : list) {
			System.out.println("orderName = "+order.getOrderName());
			//System.out.println("-----------------------------------");
			System.out.println("userName = "+order.getUser().getUserName());
		}
	} 
	
	@Test
	public void test07(){
		Order order = (Order) session.get(Order.class, 7) ;
		System.out.println("-----------------------------");
		String userName = order.getUser().getUserName() ;
		System.out.println("userName = "+userName);
	}
	
	@Test
	public void test06(){
		List<User> list = session.createQuery("From User").list() ;
		
		for (User user : list) {
			System.out.println("userName = "+user.getUserName());
			int size = user.getOrders().size() ;
			System.out.println("集合长度="+size);
		}
	}
	
	@Test
	public void test05(){
		User user = (User) session.get(User.class, 2) ;
		Set<Order> orders = user.getOrders() ;
		for (Order order : orders) {
			System.out.println("orderName="+order.getOrderName());
		}
		
	}
	
	@Test
	public void test04(){
		User user = new User(null, "Tom04") ;
		Order order1 = new Order(null, "order07") ;
		Order order2 = new Order(null, "order08") ;
		Order order3 = new Order(null, "order09") ;
		
		//设定关联关系
		Set<Order> orders = user.getOrders() ;
		orders.add(order1) ;
		orders.add(order2) ;
		orders.add(order3) ;
		
		order1.setUser(user);
		order2.setUser(user);
		order3.setUser(user);
		
		session.save(user) ;
	}
	
	@Test
	public void test03(){
		//级联删除
		User user = (User) session.get(User.class, 1) ;
		session.delete(user);
	}
	
	@Test
	public void test01(){
		User user = new User(null, "Tom02") ;
		Order order1 = new Order(null, "order04") ;
		Order order2 = new Order(null, "order05") ;
		Order order3 = new Order(null, "order06") ;
		
		//设定关联关系
		Set<Order> orders = user.getOrders() ;
		orders.add(order1) ;
		orders.add(order2) ;
		orders.add(order3) ;
		
		order1.setUser(user);
		order2.setUser(user);
		order3.setUser(user);
		
		//保存
		session.save(user) ;
		session.save(order1);
		session.save(order2);
		session.save(order3);
	}
	
	@Before
	public void init() {
		Configuration configure = new Configuration().configure();
		
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configure.getProperties());
		
		ServiceRegistry registry = builder.buildServiceRegistry();
		
		factory = configure.buildSessionFactory(registry);
		
		session = factory.openSession();
		
		transaction = session.beginTransaction();
	}
	
	@After
	public void destroy() {
		transaction.commit();
		session.close();
		factory.close();
	}
	
	@Test
	public void creatTable() {}

}
