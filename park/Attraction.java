package project6.park;


import java.util.ArrayList;

public class Attraction
{
	
	private static int attractionCounter = 0;
	private String attractionID;
	private int ratePerMinute;
	private ArrayList<NormalRider> alNormalLine;
	private ArrayList<FastRider> alFastLine;
	private ArrayList<Rider> gotOnRide;
	
	public Attraction()
	{
		
		this.setAttractionID();
		
	}
	
	public Attraction(int ratePerMinute)
	{
		
		
		
	}
	
	public void setRatePerMinute(int ratePerMinute)
	{
		
		this.ratePerMinute = ratePerMinute;
		
	}
	
	public void setAttractionID()
	{
		
		this.attractionID = String.format("RIDE%d", ++Attraction.attractionCounter);
		
	}
	
	public int getRatePerMinute()
	{
		
		return this.ratePerMinute;
		
	}
	
	public String getAttractionID()
	{
		
		return this.attractionID;
		
	}
	
	public void addRiderNormalLine(NormalRider rider)
	{
		
		this.alNormalLine.add(rider);
		
	}
	
	public void addRiderFastLine(FastRider rider)
	{
		
		this.alFastLine.add(rider);
		
	}
	
	public NormalRider removeRiderNormalLine()
	{
		
		NormalRider rider = this.alNormalLine.get(0);
		
		this.alNormalLine.remove(0);
		
		return rider;
		
	}
	
	public FastRider removeRiderFastLine()
	{
		
		FastRider rider = this.alFastLine.get(0);
		
		this.alFastLine.remove(0);
		
		return rider;
		
	}
	
	public int getAlNormalLineSize()
	{
		
		return this.alNormalLine.size();
		
	}
	
	public int getAlFastLineSize()
	{
		
		return this.alNormalLine.size();
		
	}
	
	public void addGotOnRide(Rider rider)
	{
		
		this.gotOnRide.add(rider);
		
	}
	
	public Rider getGotOnRide(int i)
	{
		
		return this.gotOnRide.get(i);
		
	}
	
	public int getAlGotOnRideSize()
	{
		
		return this.gotOnRide.size();
		
	}
	
}