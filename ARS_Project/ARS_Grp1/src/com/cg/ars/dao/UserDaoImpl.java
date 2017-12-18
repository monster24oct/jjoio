package com.cg.ars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.ars.dto.BookingDTO;
import com.cg.ars.dto.FlightDTO;
import com.cg.ars.exception.AirlineException;
import com.cg.ars.util.DBUtil;

public class UserDaoImpl implements IUserDao{
	static Connection connection = null;	
	static{
		connection = DBUtil.getConnect();
	}

	@Override
	public int bookTicket(BookingDTO bookingDto) throws AirlineException {
		// TODO Auto-generated method stub
		List<BookingDTO> rentalList;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "select * from flight_information where departure_city=? AND arrival_city=?";
		try {			
			statement = connection.prepareStatement(query);
			
		}
		catch (Exception e) {			
			throw new AirlineException("something went wrong while matching login credential...");
		}	
		return 0;
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
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT password FROM users WHERE username=?";
		String pass="";
		try {			
			statement = connection.prepareStatement(query);
			statement.setString(1,name);
			resultSet = statement.executeQuery();
			//fetch details if result set is not null
			resultSet.next();
			pass=resultSet.getString("password");		
		} catch (Exception e) {			
			throw new AirlineException("something went wrong while matching login credential...");
		}		
		return pass;
	}
	public int getUserId(String name) throws AirlineException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT userId FROM users WHERE username=?";
		int userId =0;
		try {			
			statement = connection.prepareStatement(query);
			statement.setString(1,name);
			resultSet = statement.executeQuery();
			//fetch details if result set is not null
			resultSet.next();
			userId=Integer.parseInt(resultSet.getString("userId"));		
		} catch (Exception e) {			
			throw new AirlineException("something went wrong while getting UserId.");
		}		
		return userId;
	}

	@Override
	public List<FlightDTO> getAvailFlights(BookingDTO bookingDto)
			throws AirlineException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<FlightDTO> listFlightDto = new ArrayList<FlightDTO>();
		String query = "SELECT * FROM flight_information WHERE departure_city=? AND arrival_city=?";
		try {			
			statement = connection.prepareStatement(query);
			statement.setString(1,bookingDto.getSource());
			statement.setString(2,bookingDto.getDestination());
			resultSet = statement.executeQuery();
			//fetch details if result set is not null
			while(resultSet.next())
			{
				FlightDTO flightDto = new FlightDTO();
				flightDto.setFlightId(resultSet.getInt(1));
				flightDto.setAirline(resultSet.getString(2));
				flightDto.setDepartureCity(resultSet.getString(3));
				flightDto.setArrivalCity(resultSet.getString(4));
				flightDto.setDepartureTime(resultSet.getString(5));
				flightDto.setArrivalTime(resultSet.getString(6));
				flightDto.setNoOfSeats(resultSet.getInt(7));
				flightDto.setBusFare(resultSet.getDouble(8));
				flightDto.setEcoFare(resultSet.getDouble(9));
				listFlightDto.add(flightDto);	
			}
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
			throw new AirlineException("Something went wrong while fetching showDetails");
		}
		finally
		{
			try 
			{
				resultSet.close();
				statement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				//e.printStackTrace();
				throw new AirlineException("SQLException occurred");
			}
		}
		System.out.println("returning listFlightDto");
		return listFlightDto;
	}

}
