package com.cg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.bean.UserData;

/**
 * Servlet implementation class control
 */
@WebServlet("/control.do")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target=null;
		String name=request.getParameter("name").trim();
		String pass=request.getParameter("pass").trim();
		
		if("admin".equals(name) && "admin".equals(pass)){
			HttpSession ses=request.getSession(true);
			UserData u=new UserData(name,"chennai","MIPL",10002);
			ses.setAttribute("user",null);
			target="profile.jsp";
			}
		request.getRequestDispatcher(target).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
