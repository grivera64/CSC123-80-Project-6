package project6.park;

/*
 * 
 * Name: Attraction.java
 * Purpose: Creates and manages an attraction and its lines
 * Author: grivera64
 * 
 */

import java.util.ArrayList;

public class Attraction
{
	
	//static fields
	private static int attractionCounter = 0;
	
	//other private fields
	private String attractionID;
	private int ratePerMinute;
	private ArrayList<NormalRider> alNormalLine = new ArrayList<NormalRider>();
	private ArrayList<FastRider> alFastLine = new ArrayList<FastRider>();
	private ArrayList<Rider> gotOnRide = new ArrayList<Rider>();
	
	//default constructor
	public Attraction()
	{
		
		this.attractionID = "";
		
	}
	
	//constructor that sets ratePerMinute
	public Attraction(int ratePerMinute)
	{
		
		this.setAttractionID();
		this.setRatePerMinute(ratePerMinute);
		
	}
	
	/* Mutators and Acessors */
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
	
	/* Manage different lines (Array Lists) */
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
		
		if (this.alNormalLine.size() <= 0) return null;
		
		
		return this.alNormalLine.remove(0);
		
	}
	
	public FastRider removeRiderFastLine()
	{
		
		if (this.alFastLine.size() <= 0) return null;
		
		return this.alFastLine.remove(0);
		
	}
	
	public int getAlNormalLineSize()
	{
		
		return this.alNormalLine.size();
		
	}
	
	public int getAlFastLineSize()
	{
		
		return this.alFastLine.size();
		
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