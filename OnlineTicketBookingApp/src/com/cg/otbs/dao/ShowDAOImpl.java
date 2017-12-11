/**************************************************************
File Name   : ShowDAOImpl.java
Author      : Vinayak Kanase.
Description : Performin various operation on database
***************************************************************/
package com.cg.otbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.otbs.bean.ShowDetails;
import com.cg.otbs.exception.ShowException;
import com.cg.otbs.util.DBUtil;

public class ShowDAOImpl implements IShowDAO 
{
	Connection con ;
	Statement stm ;
	PreparedStatement pstm ;
	ResultSet res ;

	@Override
	public List<ShowDetails> getShowDetails() throws ShowException 
	{
		List<ShowDetails> showDetailsList = new ArrayList<ShowDetails>();
		try
		{
			con = DBUtil.getConnection();
			stm = con.createStatement();
			res = stm.executeQuery("select * from shows");
			while(res.next())
			{
				ShowDetails show = new ShowDetails() ;
				show.setShowId(res.getString(1));
				show.setShowName(res.getString(2));
				show.setLocation(res.getString(3));
				show.setShowDate(res.getDate(4));
				show.setAvailableSeats(res.getInt(5));
				show.setPrice(res.getDouble(6));
				showDetailsList.add(show);
			}
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			throw new ShowException("Something went wrong while fetching showDetails");
		}
		finally
		{
			try 
			{
				res.close();
				stm.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				//e.printStackTrace();
				throw new ShowException("SQLException occurred");
			}
		}
		return showDetailsList;
	}

	@Override
	public ShowDetails getShowDetail(String showid) throws ShowException
	{
		ShowDetails show = null ;
		try
		{
			con = DBUtil.getConnection();
			pstm = con.prepareStatement("select * from shows where showid=?");
			pstm.setString(1, showid);
			res = pstm.executeQuery() ;
			res.next() ;
			show = new ShowDetails() ;
			show.setShowId(res.getString(1));
			show.setShowName(res.getString(2));
			show.setLocation(res.getString(3));
			show.setShowDate(res.getDate(4));
			show.setAvailableSeats(res.getInt(5));
			show.setPrice(res.getDouble(6));
			
			
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			throw new ShowException("Problem while fetching show details");
		}
		finally
		{
			try 
			{
				res.close();
				pstm.close();
				con.close();
			} 
			catch (SQLException e)
			{
				//e.printStackTrace();
				throw new ShowException("SQLException occurred");
			}
			
		}
		return show;
	}

	@Override
	public void updateShowDetails(int seats , String showname) throws ShowException 
	{
		try
		{
			con = DBUtil.getConnection() ;
			pstm = con.prepareStatement("update shows set avseats = ? where showname = ?") ;
			pstm.setInt(1, seats);
			pstm.setString(2, showname);
			pstm.executeUpdate();
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			throw new ShowException("Problem while updating the table");
		}
	}

}
