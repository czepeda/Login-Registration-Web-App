package com.login.register.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {

	public static void main(String[] args) {

		/*
		 * Session session = HibernateDbUtil.getCurrentFactorySession();
		 * 
		 * session.beginTransaction();
		 * 
		 * User user = session.get(User.class, 2);
		 * 
		 * System.out.println("Getting User with ID = 2");
		 * 
		 * System.out.println(user);
		 * 
		 * session.getTransaction().commit();
		 * 
		 * //HibernateDbUtil.closeFactory();
		 * 
		 * 
		 * 
		 * session = HibernateDbUtil.getCurrentFactorySession();
		 * 
		 * session.beginTransaction();
		 * 
		 * User user2 = session.get(User.class, 3);
		 * 
		 * System.out.println("Getting User with ID = 3");
		 * 
		 * System.out.println(user2);
		 * 
		 * session.getTransaction().commit();
		 * 
		 * HibernateDbUtil.closeFactory();
		 * 
		 */

	
		String hash = MD5Hash.md5("The quick brown fox jumps over the lazy dog");
		String hash2 = MD5Hash.md5("thesmiths209");
		System.out.println(hash);
		System.out.println(hash2);

		

	}

}
