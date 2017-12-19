package com.cg.ars.service;

import java.util.List;

import com.cg.ars.dao.IUserDao;
import com.cg.ars.dao.UserDaoImpl;
import com.cg.ars.dto.BookingDTO;
import com.cg.ars.dto.FlightDTO;
import com.cg.ars.dto.PassengerDTO;
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
		return userDao.bookTicket(bookingDto);
	}

	@Override
	public void viewBookedTicket(int bookId) throws AirlineException {
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

	@Override
	public List<FlightDTO> getAvailFlights(BookingDTO bookingDto)
			throws AirlineException {
		// TODO Auto-generated method stub
		return userDao.getAvailFlights(bookingDto);
	}

	@Override
	public int getUserId(String name) throws AirlineException {
		// TODO Auto-generated method stub
		return userDao.getUserId(name);
	}

	@Override
	public int addPassenger(PassengerDTO passengerDto) throws AirlineException {
		// TODO Auto-generated method stub
		return userDao.addPassenger(passengerDto);
	}
}
