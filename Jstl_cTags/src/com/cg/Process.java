package com.cg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.cg.bean.UserData;

/**
 * Servlet implementation class Process
 */
@WebServlet("/process.do")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private Connection conn=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		InitialContext ic;
		String target=null;
		System.out.println("in prog");
		try {
			ic = new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/OracleDS");
			conn=ds.getConnection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from userdata");
			ArrayList<UserData> empList=new ArrayList<UserData>();
			target="result.jsp";
			while(rs.next()){
				UserData user=new UserData(rs.getString(1), rs.getString(2),rs.getString(3),rs.getInt(4));	
				empList.add(user);
				
				HttpSession ses=request.getSession(true);
				ses.setAttribute("empCollect",empList);
				System.out.println("in naming "+target);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("in naming "+target);
			request.setAttribute("emsg", e.getMessage());
			target="error.jsp";
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("in sql "+target);
			request.setAttribute("emsg", e.getMessage());
			target="error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
