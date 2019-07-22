package com.Learning.MVC_Learning.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Learning.MVC_Learning.beans.Hotel;
import com.Learning.MVC_Learning.beans.User;

public class Model {
	public void registerUser(Hotel h, User u) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Hotel.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(h);
		session.save(u);
		tx.commit();
	}
	public User getUser(Hotel h,int id){
		Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
	    SessionFactory sf = configuration.buildSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();
	    
	    User user = (User) session.get(User.class, 101);
	    
	    session.getTransaction().commit();
	    return user;
	}
	public void checkInUser(int id) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);
	    SessionFactory sf = configuration.buildSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();
	    
	    User user = (User) session.get(User.class, 101);
	    
	    user.setCheck_in(true);
	    
	    session.update(user);
	    
	    session.getTransaction().commit();
	}
	public void addHotel(Hotel h){
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Hotel.class).addAnnotatedClass(User.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(h);
		tx.commit();
	}
	public Hotel getHotel(int hotel_id){
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Hotel.class);
	    SessionFactory sf = configuration.buildSessionFactory();
	    Session session = sf.openSession();
	    session.beginTransaction();
	    
	    Hotel hotel = (Hotel) session.get(Hotel.class, 101);
	    
	    session.getTransaction().commit();
	    return hotel;
	}
	public void updateHotel(Hotel h) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Hotel.class).addAnnotatedClass(User.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(h);
		tx.commit();
	}
	
	public void removeHotel(Hotel h){
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Hotel.class).addAnnotatedClass(User.class);
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(h);
		tx.commit();
	}
}
