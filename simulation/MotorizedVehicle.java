package project6.simulation;

/*
 * 
 * Name: MotorizedVehicle.java
 * Purpose: Represetns a Vehicle type MotorizedVehicle
 * Author: grivera64
 * 
 */

public class MotorizedVehicle extends Vehicle
{
	
	//private field
	private double volumeDisplacement;
	
	/* mutator and accessor methods */
	public void setVolumeDisplacement(double volumeDisplacement)
	{
		
		this.volumeDisplacement = volumeDisplacement;
		
	}
	
	public double getVolumeDisplacement()
	{
		
		return this.volumeDisplacement;
		
	}
	
	//calculate the horse power of the vehicle
	public double calculateHorsePower()
	{
		
		return this.getVolumeDisplacement() * this.getWheels();
		
	}
	
	//@Override
	//print data of MotorizedVehicle
	public String toString()
	{
		
		return String.format("%s\nVolume Displacement: %.2f\nHas %.2f horsepower", 
				super.toString(), this.getVolumeDisplacement(), this.calculateHorsePower());
		
	}
	
	//@Override
	//check if the Vehicles have same owner, and volume displacement
	public boolean equals(Object o)
	{
		
		if (!(o instanceof MotorizedVehicle)) return false;
		
		return super.equals(o) &&
				this.getVolumeDisplacement() == ((MotorizedVehicle)o).getVolumeDisplacement();
	}
	
	
}