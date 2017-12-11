package com.cg.myair.util;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	
	static Connection con;
	static{
		try{
			InitialContext context=
					new InitialContext();
			DataSource dataSource=
					(DataSource)context.lookup("java:/oracleDs");
			con=dataSource.getConnection();
		}catch(Exception e){
			try{
				throw new Exception(e.getMessage());
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}
	public static Connection getConnect() {
		// TODO Auto-generated method stub
		return con;
	}
}
