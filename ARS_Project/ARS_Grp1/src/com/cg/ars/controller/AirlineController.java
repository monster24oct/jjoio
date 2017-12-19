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
import com.cg.ars.dto.PassengerDTO;
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
				flag = userServiceImpl.validatePassword(password,passData);
				if(flag)
				{
					System.out.println(flag);
					RequestDispatcher dispatch=request.getRequestDispatcher("UserMenu.jsp");
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
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			String departingDate=request.getParameter("departingDate");
			session.setAttribute("records",noOfPassengers);
			session.setAttribute("source",source);
			session.setAttribute("destination", destination);
			session.setAttribute("departingDate",departingDate);
			String classType = request.getParameter("class");
			Date deptDate = null;
			System.out.println("controller showAvailFlights");
			try {
				deptDate = new SimpleDateFormat("dd/MM/yyyy").parse(departingDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bookDto.setSource(source);
			bookDto.setDestination(destination);
			bookDto.setBookingDate(deptDate);
			bookDto.setNoOfPassengers(noOfPassengers);
			bookDto.setClassType(classType);
			session.setAttribute("classType",classType);
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
				System.out.println(e);
			}
		}
		if("bookingTicket".equals(action))
		{
			HttpSession session = request.getSession(false);
			RequestDispatcher dispatch=request.getRequestDispatcher("BookingDetails.jsp");
			dispatch.forward(request, response);
		}
		if("addPassenger".equals(action))
		{
			HttpSession session = request.getSession(true);
			PassengerDTO passengerDto = new PassengerDTO();
			String userId = request.getParameter("UserId");
			String flightId = request.getParameter("FlightID");
			String name = request.getParameter("Name");
			String age = request.getParameter("Age");
			String gender = request.getParameter("Gender");
			passengerDto.setUserId(Integer.parseInt(userId));
			passengerDto.setFlightId(Integer.parseInt(flightId));
			passengerDto.setPassengerName(name);
			passengerDto.setPassengerAge(Integer.parseInt(age));
			passengerDto.setPassengerGender(gender);
			System.out.println("Details Added");
			try {
				int records = userService.addPassenger(passengerDto);
			} catch (AirlineException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("passenger added");
			RequestDispatcher dispatch=request.getRequestDispatcher("BookingDetails.jsp");
			dispatch.forward(request, response);
		}
		if("addUserBooking".equals(action))
		{
			HttpSession session = request.getSession(true);
			BookingDTO bookingDto = new BookingDTO();
			String source=(String)session.getAttribute("source");
			String destination=(String)session.getAttribute("destination");
			String departingDate=(String)session.getAttribute("departingDate");
			int noOfPassengers =(Integer)session.getAttribute("records");
			String classType = (String)session.getAttribute("classType");
			Date deptDate = null;
			System.out.println("controller showAvailFlights");
			try {
				deptDate = new SimpleDateFormat("dd/MM/yyyy").parse(departingDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bookingDto.setSource(source);
			bookingDto.setDestination(destination);
			bookingDto.setBookingDate(deptDate);
			bookingDto.setNoOfPassengers(noOfPassengers);
			bookingDto.setClassType(classType);
			float classFare;
			if(classType.equals("business"))
			{
				classFare=10;
			}
			else
			{
				classFare = 20;
			}
			double fare=noOfPassengers*classFare;
			bookingDto.setTotalFare(fare);
			int userID = (Integer)session.getAttribute("userId");
			bookingDto.setUserId(userID);
		}
		if("bookTicket".equals(action))
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("BookTicket.jsp");
			dispatch.forward(request, response);
		}
		/*if("viewBooking".equals(action))
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("BookTicket.jsp");
			dispatch.forward(request, response);
		}
		if("updateBooking".equals(action))
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("BookTicket.jsp");
			dispatch.forward(request, response);
		}
		if("deleteBooking".equals(action))
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("BookTicket.jsp");
			dispatch.forward(request, response);
		}*/
		if("success".equals(action))
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("Success.jsp");
			dispatch.forward(request, response);
		}
		if("homePage".equals(action))
		{
			RequestDispatcher dispatch=request.getRequestDispatcher("UserMenu.jsp");
			dispatch.forward(request, response);
		}
	}
}
