package project6.park;


import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;

public class AmusementPark
{
	
	
	private String parkName;
	private int numAttractions;
	private ArrayList<Attraction> alAttraction = new ArrayList<Attraction>();
	
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
	
	public void runThePark(int duration)
	{
		
		int initialRiders = 23 * this.getNumAttractions();
		
		int attractIndex = -1;
		
		for (int j = 0; j < initialRiders; j++)
		{
			
			Attraction attraction = 
					this.alAttraction.get(++attractIndex % this.getNumAttractions());
			
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
		
		attractIndex = 0;
		for (int currMinute = 1; currMinute <= duration; currMinute++)
		{
			
			int newRiders = 23 * this.numAttractions;
			
			for (int j = 0; j < newRiders; j++)
			{
				
				Attraction attraction1 = 
						this.alAttraction.get(attractIndex);
				
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
				
				
				//debugging here
				//System.out.printf(
				//"DEBUG: num of attractions %d\n", this.getNumAttractions());
				
				for (int index = 0; index < this.getNumAttractions(); index++)
				{
					
					
					Attraction attraction = this.alAttraction.get(index);
					
					System.out.printf("DEBUG: On attraction %s\n", attraction.getAttractionID());
					
					int toBeProcessed = attraction.getRatePerMinute();
					
					while (toBeProcessed > 0)
					{
						
						//System.out.printf("DEBUG: #%d Curr Size: %d TBP: %d\n",
						//		index, attraction.getAlFastLineSize(), toBeProcessed);
						
						
						if (attraction.getAlFastLineSize() > 0 && toBeProcessed % 3 != 0)
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
			
				attractIndex++;
				
				attractIndex %= this.getNumAttractions();
				
			}
			
		}
		
		
	}
	
	public void printParkStatistics(PrintWriter printWriter) throws IOException
	{
		
		printWriter.printf("The statistics for %s\n\n", this.getParkName().toUpperCase());
		
		int currAttraction = 0;
		for (Attraction attraction : this.alAttraction)
		{
			
			printWriter.printf("Statistics for Attraction %s\n", attraction.getAttractionID());
			
			printWriter.printf("The total number that got on the ride is %d\n",
								attraction.getAlGotOnRideSize());
			
			int averageMinutes = 0;
			int numOfFastRiders = 0;
			int averageMinutes2 = 0;
			int numOfNormalRiders = 0;
			
			for (int index = 0; index < attraction.getAlGotOnRideSize(); index++)
			{
				
				Rider rider = attraction.getGotOnRide(index);
				
				if (!(rider instanceof FastRider))
				{
					
					numOfNormalRiders++;
				
					averageMinutes2 += rider.getEndOnlineTime() - rider.getStartOnlineTime();
					
				}
				else
				{
					
					numOfFastRiders++;
					
					averageMinutes += rider.getEndOnlineTime() - rider.getStartOnlineTime();
				
				}
				
			}
			
			printWriter.printf("There were %d Fast Riders who got on waiting "
								+ "on average of %.2f minutes\n",
								numOfFastRiders,
								averageMinutes / (double) numOfFastRiders);
			
			printWriter.printf("There were %d Normal Riders who got on waiting "
					+ "on average of %.2f minutes\n",
					numOfNormalRiders,
					averageMinutes2 / (double) numOfNormalRiders);
			
			printWriter.printf("There were %d Total Riders who got on "
					+ "waiting an average of %.2f minutes",
					numOfFastRiders + numOfNormalRiders,
					(averageMinutes + averageMinutes2) / 2.0);
			
			currAttraction++;
			
			if (currAttraction < this.getNumAttractions())
			{
				printWriter.printf("\n\n");
			}
			
		}
		
	}
	
	
}