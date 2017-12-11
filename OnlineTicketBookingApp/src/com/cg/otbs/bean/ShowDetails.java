package com.cg.otbs.bean;

import java.sql.Date;

public class ShowDetails 
{
	private String showId ;
	private String showName ;
	private String location ;
	private Date showDate ;
	private int availableSeats ;
	private double price ;
	
	public ShowDetails(String showId, String showName, String location,
			Date showDate, int availableSeats, double price) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.location = location;
		this.showDate = showDate;
		this.availableSeats = availableSeats;
		this.price = price;
	}
	
	public ShowDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShowDetails [showId=" + showId + ", showName=" + showName
				+ ", location=" + location + ", showDate=" + showDate
				+ ", availableSeats=" + availableSeats + ", price=" + price
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((showId == null) ? 0 : showId.hashCode());
		return result;
	}

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowDetails other = (ShowDetails) obj;
		if (showId == null) {
			if (other.showId != null)
				return false;
		} else if (!showId.equals(other.showId))
			return false;
		return true;
	}*/
	
	
}
