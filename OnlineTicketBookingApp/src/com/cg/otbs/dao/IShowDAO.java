package com.cg.otbs.dao;

import java.util.List;

import com.cg.otbs.bean.ShowDetails;
import com.cg.otbs.exception.ShowException;

public interface IShowDAO 
{
	List<ShowDetails> getShowDetails() throws ShowException ;
	public ShowDetails getShowDetail(String showid) throws ShowException ;
	public void updateShowDetails(int seats , String showname) throws ShowException ;
}
