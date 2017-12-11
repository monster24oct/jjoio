package com.cg.myair.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.myair.bean.UserBean;
import com.cg.myair.exception.UserException;
import com.cg.myair.service.CustomerService;
import com.cg.myair.service.CustomerServiceImpl;

/**
 * Servlet implementation class ProcessUser
 */
@WebServlet("/ProcessUser")
public class ProcessUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService service;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessUser() {
		super();
		service=new CustomerServiceImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if("home".equals(action))
		{
			HttpSession session =request.getSession(false);
			RequestDispatcher dispatch=request.getRequestDispatcher("Register.jsp");
			dispatch.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");

		if("register".equals(action))
		{
			HttpSession session =request.getSession(true);

			String name=request.getParameter("name");
			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			String mobileNum=request.getParameter("number");
			String passwd=request.getParameter("passwd");
			boolean flag=false;
			UserBean bean=new UserBean();
			try {
				flag=service.validatePassword(password,passwd);
				if(flag)
				{
					bean.setName(name);
					bean.setUserName(userName);
					bean.setPassword(password);
					bean.setMobileNumber(mobileNum);
					UserBean bean1=new UserBean();
					bean1=service.insertDetails(bean);
					session.setAttribute("beans", bean1);
					RequestDispatcher dispatch=request.getRequestDispatcher("CustomerHome.jsp");
					dispatch.forward(request, response);
				}
				else
					throw new UserException("PASSWORD IS NOT MATCHING");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				session.setAttribute("excep", e.getMessage());
				RequestDispatcher dispatch=request.getRequestDispatcher("error.jsp");
				dispatch.forward(request, response);
			}
		}
		if("pay".equals(action))
		{
			HttpSession session =request.getSession(false);

			RequestDispatcher dispatch=request.getRequestDispatcher("PayBill.jsp");
			dispatch.forward(request, response);
		}

		if("payment".equals(action))
		{
			HttpSession session =request.getSession(false);
			try{
				String amnt=request.getParameter("amount");
				session.setAttribute("amt", amnt);

				boolean flag=service.checkAmount(amnt);
				if(flag)
				{
					RequestDispatcher dispatch=request.getRequestDispatcher("Success.jsp");
					dispatch.forward(request, response);
				}
				else
					throw new UserException("Payment Amount Cannot be 0 or More than 750 !!!");
			}catch(Exception e)
			{
				session.setAttribute("excep", e.getMessage());
				RequestDispatcher dispatch=request.getRequestDispatcher("error.jsp");
				dispatch.forward(request, response);
			}
		}



	}

}
