package com.cg.ars.service;

import com.cg.ars.dao.IUserDao;
import com.cg.ars.dao.UserDaoImpl;
import com.cg.ars.dto.BookingDTO;
import com.cg.ars.exception.AirlineException;

public class UserServiceImpl implements IUserService{

	IUserDao userDao;
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		userDao = new UserDaoImpl();
	}

	@Override
	public int bookTicket(BookingDTO bookingDto) throws AirlineException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void viewBookedTicked(int bookId) throws AirlineException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateBooking(int userId) throws AirlineException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPassword(String name) throws AirlineException {
		// TODO Auto-generated method stub
		return userDao.getPassword(name);
	}
	public boolean validatePassword(String password, String passData) throws AirlineException{
		// TODO Auto-generated method stub
		boolean flag=false;
		if(password.equals(passData))
		{
			flag=true;
			
		}
		return flag;
		
	}
}
