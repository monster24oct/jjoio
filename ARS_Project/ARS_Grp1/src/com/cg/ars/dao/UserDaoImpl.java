package com.cg.ars.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.ars.dto.BookingDTO;
import com.cg.ars.dto.FlightDTO;
import com.cg.ars.dto.PassengerDTO;
import com.cg.ars.exception.AirlineException;
import com.cg.ars.util.DBUtil;

public class UserDaoImpl implements IUserDao{
	Connection connection = null;	
	

	public UserDaoImpl() {
		super();
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
		/*finally
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
		}*/
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
		/*finally
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
		}*/
		return pass;
	}
	public int getUserId(String name) throws AirlineException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT user_Id FROM users WHERE username=?";
		int userId =0;
		try {			
			statement = connection.prepareStatement(query);
			statement.setString(1,name);
			resultSet = statement.executeQuery();
			//fetch details if result set is not null
			resultSet.next();
			userId=Integer.parseInt(resultSet.getString("user_Id"));		
		} catch (Exception e) {			
			throw new AirlineException("something went wrong while getting UserId.");
		}
		/*finally
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
		}*/
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
		/*finally
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
		}*/
		System.out.println("returning listFlightDto");
		return listFlightDto;
	}

	@Override
	public int addPassenger(PassengerDTO passengerDto) throws AirlineException {
		// TODO Auto-generated method stub
		
		int userId=passengerDto.getUserId();
		String name = passengerDto.getPassengerName();
		int age = passengerDto.getPassengerAge();
		String gender = passengerDto.getPassengerGender();
		System.out.println(userId+" "+age+ "  "+name+"  "+gender);
		String query = "INSERT INTO passengers VALUES(?,passIdSequence.nextval,?,?,?)";
		System.out.println("in addPassengers");
		PreparedStatement pstmt=null;
		
		int records=0;
		try {	
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1,userId);
			pstmt.setString(2,name);
			pstmt.setInt(3,age);
			pstmt.setString(4,gender);
			
			records = pstmt.executeUpdate();
			System.out.println("query executed");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new AirlineException("Something went wrong while inserting showDetails");
		}
		/*finally
		{
			try 
			{
				pstmt.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				//e.printStackTrace();
				throw new AirlineException("SQLException occurred");
			}
		}*/
		return records;
	}
}
