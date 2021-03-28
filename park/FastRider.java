package project6.park;

/*
 * 
 * Name: FastRider.java
 * Purpose: Represents a rider that pays more to wait less
 * Author: grivera64
 * 
 */

import java.util.Random;

public class FastRider extends NormalRider implements TicketPrice
{
	
	//private fields
	private double ticketPrice;
	private int type;
	
	//default constructor
	public FastRider()
	{
		
		//do nothing
		
	}
	
	//constructor that sets startOnlineTime
	public FastRider(int startOnlineTime)
	{
		
		this.setStartOnlineTime(startOnlineTime);
		
	}
	
	/* Implements Abstract methods */
	public double getTicketPrice()
	{
		
		return this.ticketPrice;
		
	}
	
	public int getType()
	{
		
		return this.type;
		
	}
	
	public void setTicketPrice()
	{
		
		this.ticketPrice = TicketPrice.BASEPRICE * 1.2;
		
	}
	
	public void setType()
	{
		
		this.type = (new Random()).nextInt(10) + 1;
		
	}
	
	
}