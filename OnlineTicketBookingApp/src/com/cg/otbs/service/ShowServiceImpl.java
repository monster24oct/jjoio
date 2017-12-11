package com.cg.otbs.service;

import java.util.List;

import com.cg.otbs.bean.ShowDetails;
import com.cg.otbs.dao.IShowDAO;
import com.cg.otbs.dao.ShowDAOImpl;
import com.cg.otbs.exception.ShowException;

public class ShowServiceImpl implements IShowService 
{
	IShowDAO showDAO ;
	
	public ShowServiceImpl()
	{
		showDAO = new ShowDAOImpl();
	}
	
	@Override
	public List<ShowDetails> getShowDetails() throws ShowException 
	{
		return showDAO.getShowDetails();
	}

	@Override
	public ShowDetails getShowDetail(String showid) throws ShowException 
	{
		return showDAO.getShowDetail(showid);
	}

	@Override
	public void updateShowDetails(int seats , String showname) throws ShowException
	{
		 showDAO.updateShowDetails(seats , showname);
	}

}
