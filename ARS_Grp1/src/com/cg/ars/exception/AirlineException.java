package com.cg.ars.exception;

public class AirlineException extends Exception{
	private static final long serialVersionUID = 8703631351163135232L;
	public AirlineException()
	{
		super();
	}
	
	public AirlineException(String message)
	{
		super(message);
	}
}
