package project6.park;


import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;

public class AmusementPark
{
	
	
	private String parkName;
	private int numAttractions;
	private ArrayList<Attraction> alAttraction;
	
	public AmusementPark()
	{
		
		this.setParkName("");
		this.setNumAttractions(0);
		this.createAttractions(this.getNumAttractions());
		
	}
	
	public AmusementPark(String name, int numAttractions)
	{
		
		this.setParkName(name);
		this.setNumAttractions(numAttractions);
		this.createAttractions(this.getNumAttractions());
		
	}
	
	public void setParkName(String parkName)
	{
		
		this.parkName = parkName;
		
	}
	
	public String getParkName()
	{
		
		return this.parkName;
		
	}
	
	public void setNumAttractions(int numAttractions)
	{
		
		this.numAttractions = numAttractions;
		
	}
	
	public int getNumAttractions()
	{
		
		return this.numAttractions;
		
	}
	
	public void createAttractions(int numAttractions)
	{
		
		Random random = new Random(2);
		
		for (int attractionNum = 0; attractionNum < numAttractions; attractionNum++)
		{
			
				int ratePerMinute = random.nextInt(6) + 10;
				
				Attraction attraction = new Attraction(ratePerMinute);
				
				this.alAttraction.add(attraction);
			
		}
		
	}
	
	public void runThePark()
	{
		
		int initialRiders = 23 * this.getNumAttractions();
		
		for (int j = 0; j < initialRiders; j++)
		{
			
			Attraction attraction = this.alAttraction.get(j);
			
			if (j % 3 == 0 || j % 7 == 0)
			{
				
				FastRider rider = new FastRider(0);
				attraction.addRiderFastLine(rider);
				
			}
			else
			{
				
				NormalRider rider = new NormalRider(0);
				attraction.addRiderNormalLine(rider);
				
			}
			
		}
		
		for (int currMinute = 1; currMinute < 100; currMinute++)
		{
			
			int newRiders = 23 * this.numAttractions;
			
			for (int j = 0; j < newRiders; j++)
			{
				
				Attraction attraction1 = this.alAttraction.get(j);
				
				if (j % 3 == 0 || j % 7 == 0)
				{
					
					FastRider rider = new FastRider(currMinute);
					attraction1.addRiderFastLine(rider);
					
				}
				else
				{
					
					NormalRider rider = new NormalRider(currMinute);
					attraction1.addRiderNormalLine(rider);
					
				}
				
				for (Attraction attraction : this.alAttraction)
				{
					
					int toBeProcessed = attraction.getRatePerMinute();
					
					while (toBeProcessed > 0)
					{
						
						if (attraction.getAlFastLineSize() > 0 && toBeProcessed % 3 == 0)
						{
							
							FastRider rider = attraction.removeRiderFastLine();
							rider.setEndOnlineTime(currMinute);
							
							attraction.addGotOnRide(rider);
							
							toBeProcessed--;
							
						}
						else if (attraction.getAlNormalLineSize() > 0)
						{
							
							NormalRider rider = attraction.removeRiderNormalLine();
							rider.setEndOnlineTime(currMinute);
							
							attraction.addGotOnRide(rider);
							
							toBeProcessed--;
							
						}
						else
						{
							
							toBeProcessed = 0;
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
	public void printParkStatistics(PrintWriter printWriter) throws IOException
	{
		
		printWriter.printf("The statistics for %d\n\n", this.getParkName().toUpperCase());
		
		//TODO: add here the Statistics for each attraction
		
	}
	
	
}