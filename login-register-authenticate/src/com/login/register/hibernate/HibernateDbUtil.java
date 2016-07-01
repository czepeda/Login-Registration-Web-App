package com.login.register.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

public class HibernateDbUtil {

	// session factory which will be used to get sessions from
	private SessionFactory factory;
	private Session session;

	public HibernateDbUtil() {
		// singleton SessionFactory object created heavy resource so only one
		// should be instantiated once
		if (this.factory == null) {
			this.factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
					.buildSessionFactory();
		}
	}

	public Session getCurrentFactorySession() {
		// return session
		return this.factory.getCurrentSession();
	}

	public void closeFactory() {
		// close the factory
		this.factory.close();
	}

	public boolean authenticateUser(String userName, String password) {
		boolean authenticated = false;

		// get a session
		this.session = getCurrentFactorySession();

		// start a transaction
		session.beginTransaction();

		// query user_table for student object where user_id = 'userName'
		User user = null;
		try {
			user = (User) session.createQuery("from User where user_id='" + userName + "'").uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Could not query data!");
			e.printStackTrace();
		}

		if (user == null) {
			System.out.println("Username does not exist!");
			authenticated = false;
		} else if (user.getUserId().equals(userName) && user.getPassword().equals(MD5Hash.md5(password))) {
			System.out.println("Username and Password Match!");
			authenticated = true;
		} else {
			System.out.println("Password does not Match!");
			authenticated = false;
		}

		return authenticated;

	}

}
