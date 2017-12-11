/**************************************************************
File Name   : ShowController.java
Author      : Vinayak Kanase.
Description : Consist of Logic 
***************************************************************/
package com.cg.otbs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.otbs.bean.ShowDetails;
import com.cg.otbs.exception.ShowException;
import com.cg.otbs.service.IShowService;
import com.cg.otbs.service.ShowServiceImpl;

@WebServlet(urlPatterns={"/listAllShows","/getShowDetails","/BookTicket"})
public class ShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IShowService showService ;
    public ShowController() 
    {
        super();
        showService = new ShowServiceImpl();
       
    }

	public void init(ServletConfig config) throws ServletException 
	{
		
	}

	public void destroy() 
	{
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//calling doPost in doGet
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath() ;
		String url="" ;
		
		try
		{
		switch (path) 
		{
			//firstcase which will show all details
			case "/listAllShows":
				System.out.println("Hello");
				List<ShowDetails> showList = showService.getShowDetails();
				//System.out.println(showList);
				HttpSession session = request.getSession();
				session.setAttribute("showList", showList);
				url="showDetails.jsp";
				break;
				
			//second case which will send us to show bookNow.jsp
			case "/getShowDetails" :
				System.out.println("Getting Show Details");
				String showid = request.getParameter("showid") ;
				System.out.println(showid);
				ShowDetails show = showService.getShowDetail(showid);
				System.out.println(show);
				request.setAttribute("show", show);
				url="bookNow.jsp";
				break;
				
			/* third case which will book ticket based on the values enterd in 
				bookNow.jsp and redirect to success.jsp if booking is done successfully
				*/
			case "/BookTicket":
				String showName = request.getParameter("txtShowName");
				double price = Double.parseDouble(request.getParameter("txtPrice")) ;
				String customerName = request.getParameter("txtCustName");
				long mob =Long.parseLong(request.getParameter("txtMobNo"));
				int availSeats = Integer.parseInt(request.getParameter("txtSeatsAvail"));
				int noOfSeats = Integer.parseInt(request.getParameter("txtSeatsBook"));
				
				if(noOfSeats == 0 || noOfSeats < 0)
				{
					throw new ShowException("Please Enter valid no of seats");
				}
				
				if(availSeats < noOfSeats)
				{
					throw new ShowException("Please Enter valid no of seats");
				}
				else
				{
					int updatedSeats = availSeats-noOfSeats ;
					request.setAttribute("showname", showName);
					request.setAttribute("cname", customerName);
					request.setAttribute("mobileNo", mob);
					request.setAttribute("noOfSeats", noOfSeats);
					double totalPrice = price * noOfSeats ;
					request.setAttribute("totalPrice", totalPrice);
					showService.updateShowDetails(updatedSeats , showName);
					url = "success.jsp" ;
				}
				
				break ;

		default:
			break;
		}
		}
		catch(ShowException e)
		{
			request.setAttribute("error", e.getMessage());
			url = "error.jsp" ;
		}
		catch (Exception e) 
		{
			request.setAttribute("error", e.getMessage());
			url = "error.jsp" ;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
