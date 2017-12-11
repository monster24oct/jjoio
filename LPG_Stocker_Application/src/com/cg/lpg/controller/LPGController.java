package com.cg.lpg.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.lpg.bean.LPGStockBean;
import com.cg.lpg.exception.LPGException;
import com.cg.lpg.service.ILPGService;
import com.cg.lpg.service.LPGServiceImpl;

@WebServlet("/LPGController")
public class LPGController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Creating the service
	ILPGService lpgService = new LPGServiceImpl();

	public LPGController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true); // creating session
		String action = request.getParameter("action");
		System.out.println("action is ....." + action);
		String location = request.getParameter("location");
		System.out.println("Location is " + location);
		// Display stock details if location is present
		if (location != null) {
			session.setAttribute("location", location);
			try {
				ArrayList<LPGStockBean> stockList = lpgService
						.getStockDetails(location);
				if (stockList.isEmpty())
					throw new LPGException("Sorry! No records found...");
				session.setAttribute("list", stockList);
			} catch (LPGException e) {
				throw new ServletException(e);
			}

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("getStock.jsp");
			dispatcher.forward(request, response);
		}

		// transfer control to updateStock form
		if ("updateForm".equals(action)) {
			String quantity = request.getParameter("qty");
			String provider = request.getParameter("provider");
			session.setAttribute("availableQty", quantity);
			session.setAttribute("provider", provider);
			RequestDispatcher dispatcher1 = request
					.getRequestDispatcher("updateStock.jsp");
			dispatcher1.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String action = request.getParameter("action");
		// Update stock details
		if ("update".equals(action)) {
			int requiredQuantity = Integer.parseInt(request
					.getParameter("requiredQty"));
			String gasProvider = request.getParameter("provider");
			try {
				boolean flag = lpgService.updateStockDetails(requiredQuantity,
						gasProvider);
				if (flag) {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("success.jsp");
					dispatcher.forward(request, response);
				}
			} catch (LPGException e) {
				throw new ServletException(e);

			}

		}
	}

}
