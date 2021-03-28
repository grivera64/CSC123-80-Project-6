package project6.park;

/*

	Name: NormalRider.java
	Purpose: Encapsulates a normal rider
	Author: grivera64

*/

import java.util.Random;

public class NormalRider extends Rider implements TicketPrice
{
	
	
	private double ticketPrice;
	private int type;
	
	public NormalRider()
	{
		
		//does nothing
		
	}
	
	public NormalRider(int startOnlineTime)
	{
		
		this.setStartOnlineTime(startOnlineTime);
		
	}
	
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
		
		this.ticketPrice = TicketPrice.BASEPRICE;
		
	}
	
	public void setType()
	{
		
		this.type = (new Random()).nextInt(5) + 1;
		
	}
	
}