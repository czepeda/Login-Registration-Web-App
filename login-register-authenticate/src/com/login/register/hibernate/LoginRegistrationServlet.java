package com.login.register.hibernate;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet("/LoginRegistrationServlet")
public class LoginRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HibernateDbUtil utilityConn = new HibernateDbUtil();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// command that is being sent from .jsp and .html pages
		String theCommand = request.getParameter("command");

		if (theCommand == null) {
			theCommand = "LOGIN";
		}

		switch (theCommand) {
		case "LOGIN":
			loginPage(request, response);
			break;
		case "REGISTER":
			registrationPage(request, response);
			break;
		case "SUCCESSFUL":
			succesfulPage(request, response);
			break;
		case "ERROR":
			errorPage(request, response);
			break;
		case "AUTHENTICATE":
			authenticateCredentials(request, response);
			break;

		}

	}

	private void authenticateCredentials(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// get userName and password from from login.jsp file
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		// boolean that will be assigned authentication value 
		boolean authenticated = false;
		
		// boolean using util object to get authentication
		authenticated = utilityConn.authenticateUser(userName, password);
		
		
		RequestDispatcher dispatcher;

		if (authenticated) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/JSP Files/valid.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("/WEB-INF/JSP Files/invalid.jsp");
		}

		dispatcher.forward(request, response);

	}

	private void errorPage(HttpServletRequest request, HttpServletResponse response) {

	}

	private void succesfulPage(HttpServletRequest request, HttpServletResponse response) {

	}

	private void registrationPage(HttpServletRequest request, HttpServletResponse response) {

	}

	private void loginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login Page");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP Files/login.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// command that is being sent from .jsp and .html pages
		String theCommand = request.getParameter("command");

		if (theCommand == null) {
			theCommand = "LOGIN";
		}

		switch (theCommand) {
		case "LOGIN":
			loginPage(request, response);
			break;
		case "REGISTER":
			registrationPage(request, response);
			break;
		case "SUCCESSFUL":
			succesfulPage(request, response);
			break;
		case "ERROR":
			errorPage(request, response);
			break;
		case "AUTHENTICATE":
			authenticateCredentials(request, response);
			break;

		}

	}

}
