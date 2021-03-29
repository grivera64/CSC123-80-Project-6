package project6.park;

/*

	Name: NormalRider.java
	Purpose: Encapsulates a normal rider
	Author: grivera64

*/

//to use Random class
import java.util.Random;

public class NormalRider extends Rider implements TicketPrice
{
	
	//private fields
	private double ticketPrice;
	private int type;
	
	//default constructor
	public NormalRider()
	{
		
		//does nothing
		
	}
	
	//constructor that sets startOnline time
	public NormalRider(int startOnlineTime)
	{
		
		this.setStartOnlineTime(startOnlineTime);
		
	}
	
	/* Accessors and Mutators */
	public double getTicketPrice()
	{
		
		return this.ticketPrice;
		
	}
	
	/* Implementing Rider and TicketPrice methods */
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