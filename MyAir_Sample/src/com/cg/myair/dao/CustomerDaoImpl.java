package com.cg.myair.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.myair.bean.UserBean;
import com.cg.myair.exception.UserException;
import com.cg.myair.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	Connection con;
	
	public CustomerDaoImpl()
	{
		con=DBUtil.getConnect();
	}
	
	@Override
	public UserBean insertDetails(UserBean bean) throws UserException {
		// TODO Auto-generated method stub
		String sql="INSERT into users VALUES(?,?,?,?)";
		PreparedStatement pst=null;
		ResultSet result=null;
		boolean flag=false;
		int billId=0;
		try {
			pst=con.prepareStatement(sql);
			con.setAutoCommit(false);
			pst.setString(1, bean.getName());
			pst.setString(2, bean.getUserName());
			pst.setString(3, bean.getPassword());
			pst.setString(4, bean.getMobileNumber());

			result=pst.executeQuery();
			if(result!=null){
					flag=true;
			}
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UserException("Registration Failed");
		}
		return bean;
	}


}
