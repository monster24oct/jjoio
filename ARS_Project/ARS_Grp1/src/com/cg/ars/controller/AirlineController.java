package com.cg.ars.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.ars.dto.BookingDTO;
import com.cg.ars.dto.FlightDTO;
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
				int userId = userService.getUserId(name);
				session.setAttribute("userId", userId);
				String passData = userService.getPassword(name);
				System.out.println("*****************"+passData);
				flag = userServiceImpl.validatePassword(password,passData);
				if(flag)
				{
					System.out.println(flag);
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
		if("showAvailFlights".equals(action))
		{
			HttpSession session = request.getSession(true);
			BookingDTO bookDto = new BookingDTO();
			int noOfPassengers =Integer.parseInt(request.getParameter("noOfPassengers"));
			int records=0;
			session.setAttribute("records",noOfPassengers);
			String departingDate=request.getParameter("departingDate");
			Date deptDate = null;
			System.out.println("controller showAvailFlights");
			try {
				deptDate = new SimpleDateFormat("dd/MM/yyyy").parse(departingDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bookDto.setSource(request.getParameter("source"));
			bookDto.setDestination(request.getParameter("destination"));
			bookDto.setBookingDate(deptDate);
			bookDto.setNoOfPassengers(noOfPassengers);
			List<FlightDTO> listFlightDto = new ArrayList<FlightDTO>();
			System.out.println("calling to get avail flights");
			try
			{
				listFlightDto = userService.getAvailFlights(bookDto);
				session.setAttribute("listFlightDto", listFlightDto);
				RequestDispatcher dispatch=request.getRequestDispatcher("FlightDetail.jsp");
				dispatch.forward(request, response);	
			}
			catch(Exception e)
			{
				
			}
		}
		if("bookTicket".equals(action))
		{
			HttpSession session = request.getSession(false);
			RequestDispatcher dispatch=request.getRequestDispatcher("BookTicket.jsp");
			dispatch.forward(request, response);
		}
	}

}
