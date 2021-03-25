package project6.simulation;

public class MotorizedVehicle extends Vehicle
{
	
	
	private double volumeDisplacement;
	
	public MotorizedVehicle()
	{
		
		this.setOwner("No Owner");
		this.setWheels(4);
		this.setVolumeDisplacement(0.0);
		
	}
	
	public void setVolumeDisplacement(double volumeDisplacement)
	{
		
		this.volumeDisplacement = volumeDisplacement;
		
	}
	
	public double getVolumeDisplacement()
	{
		
		return this.volumeDisplacement;
		
	}
	
	public double calculateHorsePower()
	{
		
		return this.getVolumeDisplacement() * this.getWheels();
		
	}
	
	//@Override
	public String toString()
	{
		
		return String.format("%s\n%f\n has %f horsepower", 
				super.toString(), this.getVolumeDisplacement(), this.calculateHorsePower());
		
	}
	
	//@Override
	public boolean equals(Object o)
	{
		
		
		return super.equals(o) &&
				this.getVolumeDisplacement() == ((MotorizedVehicle)o).getVolumeDisplacement();
	}
	
	
}