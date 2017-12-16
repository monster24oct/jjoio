package com.cg.ars.dao;

import com.cg.ars.dto.BookingDTO;
import com.cg.ars.exception.AirlineException;

public interface IUserDao {

	public int bookTicket(BookingDTO bookingDto)throws AirlineException;
	public void viewBookedTicked(int bookId)throws AirlineException;
	public boolean updateBooking(int userId)throws AirlineException;
}
