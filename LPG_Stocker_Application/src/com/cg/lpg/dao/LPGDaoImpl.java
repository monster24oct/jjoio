package com.cg.lpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.cg.lpg.bean.LPGStockBean;
import com.cg.lpg.exception.LPGException;
import com.cg.util.DBUtil;

public class LPGDaoImpl implements ILPGDao{

	static Connection connection = null;	
	static{
		connection = DBUtil.getConnect();
	}
	@Override
	public ArrayList<LPGStockBean> getStockDetails(String location)throws LPGException {
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM LPGStock WHERE location=?";
		System.out.println("Location is "+location);
		ArrayList<LPGStockBean> stockList = new ArrayList<LPGStockBean>();
		LPGStockBean bean = null;
		try {			
			statement = connection.prepareStatement(query);
			statement.setString(1,location);
			resultSet = statement.executeQuery();
			//fetch details if result set is not null
			while(resultSet.next())
			{
				System.out.println("Resultset coming");
				bean = new LPGStockBean();
				bean.setAvQty(resultSet.getInt(1));
				bean.setReceivedDate(resultSet.getDate(2).toLocalDate());
				bean.setUpdatedBy(resultSet.getString(3));
				bean.setLocation(resultSet.getString(4));
				stockList.add(bean);				
			}			
		} catch (Exception e) {			
			throw new LPGException("something went wrong while fetching stock details...");
		}		
		return stockList;
	}
	@Override
	public boolean updateStockDetails(int quantity,String provider)throws LPGException {
		PreparedStatement statement = null;
		int result = 0;
		String query = "UPDATE LPGStock SET avqty=avqty-? WHERE updatedby=?";
		boolean flag = false;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1,quantity);
			statement.setString(2, provider);
			result = statement.executeUpdate();
			
			if(result > 0)
				flag=true;
			else
				throw new LPGException("Something went wrong while processing your request...");
		} catch (Exception e) {
			
			throw new LPGException("Unable to update stock details at this moment...");
		}
		return flag;
	}

}
