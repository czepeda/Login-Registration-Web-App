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
		// boolean that will be assigned authentication value
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

	public boolean registerUser(User user) {
		// boolean that will be returned to see if registration was succesful
		boolean register = false;

		// query user_table for student object where user_id = 'userName' of the
		// User object being passed in
		// true userName is not available
		User userAlreadyExist = null;

		try {
			// get a session
			this.session = getCurrentFactorySession();

			// start a transaction
			session.beginTransaction();

			userAlreadyExist = (User) session.createQuery("from User where user_id='" + user.getUserId() + "'")
					.uniqueResult();

			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Could not query data user does not Exist!");
			e.printStackTrace();
		}

		String emptyString = "";

		if (userAlreadyExist != null) {
			System.out.println("Username taken!");
			register = false;
			return register;
		} else if ((user.getFirstName().equals(emptyString)) || (user.getLastName().equals(emptyString))
				|| (user.getEmail().equals(emptyString)) || (user.getUserId().equals(emptyString))
				|| (user.getPassword().equals(emptyString))) {
			// one of the variables or all are empty
			System.out.println("One or all variables are blank!");
			register = false;
			return register;
		} else {
			// if user doesn't exist make a new connection and input the user
			// into the table
			register = true;
			
			// user object that will be registered into the DB
			User userToRegister = user;

			// hash the user password by calling the MD5Hash class and passing
			// in the password from the user object
			String hashedPassword = MD5Hash.md5(user.getPassword());

			// set the hashed password into the User object that will be
			// inserted into the DB
			userToRegister.setPassword(hashedPassword);

			// get a session
			this.session = getCurrentFactorySession();

			// start a transaction
			session.beginTransaction();

			// save the User object
			try {
				System.out.println("Saving the user.");
				session.save(userToRegister);
				// commit transaction
				session.getTransaction().commit();
			} catch (Exception e) {
				System.out.println("Could not insert data!");
				e.printStackTrace();
			}

			return register;
		}

	}

}
