package com.cg.ars.dao;

import java.util.List;

import com.cg.ars.dto.BookingDTO;
import com.cg.ars.dto.FlightDTO;
import com.cg.ars.dto.PassengerDTO;
import com.cg.ars.exception.AirlineException;

public interface IUserDao {

	public int bookTicket(BookingDTO bookingDto)throws AirlineException;
	public void viewBookedTicket(int bookId)throws AirlineException;
	public boolean updateBooking(int userId)throws AirlineException;
	public String getPassword(String name)throws AirlineException;
	public List<FlightDTO> getAvailFlights(BookingDTO bookingDto)throws AirlineException;
	public int getUserId(String name) throws AirlineException;
	public int addPassenger(PassengerDTO passengerDto)throws AirlineException;
}
