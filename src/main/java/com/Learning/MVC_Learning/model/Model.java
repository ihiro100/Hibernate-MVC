package com.Learning.MVC_Learning.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Learning.MVC_Learning.beans.Hotel;
import com.Learning.MVC_Learning.beans.Customer;

public class Model {
	public void registerUser(Hotel h, Customer u) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Hotel.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(h);
		session.save(u);
		tx.commit();
		session.close();
	}
	public Customer getUser(int id){
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Hotel.class);
	    SessionFactory sf = configuration.buildSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();
	    
	    Customer user = (Customer) session.get(Customer.class, id);
	    
	    session.getTransaction().commit();
	    session.close();
	    return user;
	}
	public void checkInToggleUser(int id, boolean status) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Hotel.class);
	    SessionFactory sf = configuration.buildSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();
	    
	    Customer user = (Customer) session.get(Customer.class, id);
	    
	    user.setCheck_in(status);
	    
	    session.update(user);
	    
	    session.getTransaction().commit();
	    session.close();
	}
	public void addHotel(Hotel h){
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Hotel.class).addAnnotatedClass(Customer.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(h);
		tx.commit();
		session.close();
		
	}
	public Hotel getHotel(int hotel_id){
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Hotel.class);
	    SessionFactory sf = configuration.buildSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();
	    
	    Hotel hotel = (Hotel) session.get(Hotel.class, hotel_id);
	    System.out.println("from database hotel: "+hotel);
	    session.getTransaction().commit();
	    session.close();
	    return hotel;
	}
	public void updateHotel(Hotel h) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Hotel.class).addAnnotatedClass(Customer.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(h);
		session.close();
		tx.commit();
	}
	
	public void removeHotel(Hotel h){
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Hotel.class).addAnnotatedClass(Customer.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(h);
		session.close();
		tx.commit();
	}
	
	public void deleteUser(int id){
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Hotel.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer user = (Customer) session.get(Customer.class, id);
		System.out.println(user);
		
		session.delete(user);
		session.close();
		tx.commit();
	}
}
