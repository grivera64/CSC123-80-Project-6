package project6.simulation;

public abstract class Vehicle
{
	
	
	private String owner;
	private int wheels;
	
	public void setOwner(String owner)
	{
		
		this.owner = owner;
		
	}
	
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
	public String toString()
	{
		
		return String.format("Owner: %s\nNumber of wheels: %d", this.owner, this.wheels);
		
	}
	
	//@Override
	public boolean equals(Object o)
	{
		
		if (!(o instanceof Vehicle)) return false;
		
		return this.getOwner() == ((Vehicle)o).getOwner() &&
				this.getWheels() == ((Vehicle) o).getWheels();
		
	}
	
}