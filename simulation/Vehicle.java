package project6.simulation;

/*
 * 
 * Name: Vehicle.java
 * Purpose: Represents the basic components of a Vehicle
 * Author: grivera64
 * 
 */

public abstract class Vehicle
{
	
	//private fields
	private String owner;
	private int wheels;
	
	//constructor
	public void setOwner(String owner)
	{
		
		this.owner = owner;
		
	}
	
	/* Accessors and Mutators */
	public String getOwner()
	{
		
		return this.owner;
		
	}
	
	public void setWheels(int wheels)
	{
		
		this.wheels = wheels;
	
	}
	
	public int getWheels()
	{
		
		return this.wheels;
		
	}
	
	//@Override
	//Overriding Object toString method to print Vehicle data
	public String toString()
	{
		
		return String.format("Owner: %s\nNumber of wheels: %d", this.owner, this.wheels);
		
	}
	
	//@Override
	//Overriding Object equals method to check if Owner and wheel number is same
	public boolean equals(Object o)
	{
		
		if (!(o instanceof Vehicle)) return false;
		
		return this.getOwner() == ((Vehicle)o).getOwner() &&
				this.getWheels() == ((Vehicle) o).getWheels();
		
	}
	
}