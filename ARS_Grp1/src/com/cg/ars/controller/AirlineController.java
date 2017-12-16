package com.cg.ars.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.ars.dto.UsersDTO;
import com.cg.ars.exception.AirlineException;
import com.cg.ars.service.IUserService;
import com.cg.ars.service.UserServiceImpl;

/**
 * Servlet implementation class AirlineController
 */
@WebServlet("/AirlineController")
public class AirlineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService;
	UserServiceImpl userServiceImpl;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AirlineController() {
		super();
		userService = new UserServiceImpl();
		userServiceImpl = new UserServiceImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if("home".equals(action))
		{
			HttpSession session =request.getSession(false);
			RequestDispatcher dispatch=request.getRequestDispatcher("index.jsp");
			dispatch.forward(request, response);
		}
		if("login".equals(action)) 
		{
			HttpSession session = request.getSession(true);
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String role = request.getParameter("role");
			boolean flag=false;
			UsersDTO bean=new UsersDTO();
			try {
				String passData = userService.getPassword(name);
				flag = userServiceImpl.validatePassword(password,passData);
				if(flag)
				{
					RequestDispatcher dispatch=request.getRequestDispatcher("Passenger.jsp");
					dispatch.forward(request, response);
				}
				else
					throw new AirlineException("PASSWORD IS NOT MATCHING");

			} catch (AirlineException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				session.setAttribute("excep", e.getMessage());
				RequestDispatcher dispatch=request.getRequestDispatcher("error.jsp");
				dispatch.forward(request, response);
			}
			
			
		}
	}

}
