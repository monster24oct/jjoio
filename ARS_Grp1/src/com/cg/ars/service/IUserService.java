package com.cg.ars.service;

import com.cg.ars.dto.BookingDTO;
import com.cg.ars.exception.AirlineException;

public interface IUserService {

	public int bookTicket(BookingDTO bookingDto)throws AirlineException;
	public void viewBookedTicked(int bookId)throws AirlineException;
	public boolean updateBooking(int userId)throws AirlineException;
	public String getPassword(String name)throws AirlineException;
}
