package com.cg.ars.dto;

public class FlightDTO {
	private int flightId;
	private String airline;
	private String departureCity;
	private String arrivalCity;
	private String departureTime;
	private String arrivalTime;
	private int noOfSeats;
	private double ecoFare;
	private double busFare;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public double getEcoFare() {
		return ecoFare;
	}
	public void setEcoFare(double ecoFare) {
		this.ecoFare = ecoFare;
	}
	public double getBusFare() {
		return busFare;
	}
	public void setBusFare(double busFare) {
		this.busFare = busFare;
	}
	

}
