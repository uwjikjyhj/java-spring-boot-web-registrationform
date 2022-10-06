package com.registrationform.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.registrationform.dao.UserDao;
import com.registrationform.dao.UserDaoTemplateImpl;
import com.registrationform.dto.User;

/**
 * Servlet implementation class FormServlet
 */
//@Component("FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDao dao;
	
    /**
     * Default constructor. 
     */
    public FormServlet() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String mobileNo = request.getParameter("mobile");
		String address = request.getParameter("addr");
		
		User user = new User(name, age, mobileNo, address);

		dao.saveUser(user);
		
		User savedUser = dao.getUserByMobileNo(mobileNo);
		request.setAttribute("user", savedUser);
			
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}

}
