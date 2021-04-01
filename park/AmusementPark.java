package project6.park;


import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;

public class AmusementPark
{
	
	//private fields
	private String parkName;
	private int numAttractions;
	private ArrayList<Attraction> alAttraction = new ArrayList<Attraction>();
	
	//default constructor
	public AmusementPark()
	{
		
		this.setParkName("");
		this.setNumAttractions(0);
		this.createAttractions(0);
		
	}
	
	
	//sets the name and number of attractions in the park
	public AmusementPark(String name, int numAttractions)
	{
		
		this.setParkName(name);
		this.setNumAttractions(numAttractions);
		this.createAttractions(this.getNumAttractions());
		
	}
	
	/* Mutators and Accessors */
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
	
	//creates all of the attractions for the park
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
	
	//runs the park (all of the logic runs here)
	public void runThePark(int duration)
	{
		
		//set up the intial number of riders at minute 0
		int initialRiders = 23 * this.getNumAttractions();
		
		//temporary variables (recommended instead of each location
		//for faster execution)
		
		Attraction currAttraction;
		FastRider currFastRider;
		NormalRider currNormalRider;
		
		//set up each rider at minute 0 and add to each attraction
		//in a round-robin fashion
		for (int j = 0; j < initialRiders; j++)
		{
			
			currAttraction = this.alAttraction.get(j % this.getNumAttractions());
			
			if (j % 3 == 0 || j % 7 == 0)
			{
				
				currFastRider = new FastRider(0);
				currAttraction.addRiderFastLine(currFastRider);
				
			}
			else
			{
				
				currNormalRider = new NormalRider(0);
				currAttraction.addRiderNormalLine(currNormalRider);
				
			}
			
		}
		
		//temporary variable
		int newRiders;
		
		//set up each rider at a different minute of the simulation
		for (int currMinute = 1; currMinute <= duration; currMinute++)
		{
			
			newRiders = 23 * this.getNumAttractions();
			
			for (int j = 0; j < newRiders; j++)
			{
				
				currAttraction = this.alAttraction.get(j % this.getNumAttractions());

				
				if (j % 3 == 0 || j % 7 == 0)
				{
					
					currFastRider = new FastRider(currMinute);
					currAttraction.addRiderFastLine(currFastRider);
					
				}
				else
				{
					
					currNormalRider = new NormalRider(currMinute);
					currAttraction.addRiderNormalLine(currNormalRider);
					
				}
				
			} //end for loop (j)
			
			//debugging here
			//System.out.printf(
			//"DEBUG: num of attractions %d\n", this.getNumAttractions());
			
			//temporary variable to store the processed riders during the simulation
			int toBeProcessed;
			
			//save the riders that were able to get on the ride based on the rpm
			//of each of the attractions
			for (Attraction attraction : this.alAttraction)
			{
				
				
				//System.out.printf("DEBUG: On attraction %s\n", attraction.getAttractionID());
				
				toBeProcessed = attraction.getRatePerMinute();
				
				//remove each rider from the original lines and place them into the ride
				while (toBeProcessed > 0)
				{
					
					//System.out.printf("DEBUG: #%d Curr Size: %d TBP: %d\n",
					//		index, attraction.getAlFastLineSize(), toBeProcessed);
					
					
					if (attraction.getAlFastLineSize() != 0 && toBeProcessed % 3 != 0)
					{
						
						currFastRider = attraction.removeRiderFastLine();
						
						currFastRider.setEndOnlineTime(currMinute);
						
						attraction.addGotOnRide(currFastRider);
						
						toBeProcessed--;
						
					}
					else if (attraction.getAlNormalLineSize() != 0)
					{
						
						currNormalRider = attraction.removeRiderNormalLine();
						
						currNormalRider.setEndOnlineTime(currMinute);
						
						attraction.addGotOnRide(currNormalRider);
						
						toBeProcessed--;
						
					}
					else
					{
						//stop removing riders
						toBeProcessed = 0;
						
					}
					
				} //end while
				
			} //end for each loop
				
			
		} //end for loop (currMinute)
		
		
	}
	
	//print the data into a file specified by the user
	public void printParkStatistics(PrintWriter printWriter) throws IOException
	{
		//header for park
		printWriter.printf("The statistics for %s\n\n", this.getParkName().toUpperCase());
		
		//statistics per attraction
		for (Attraction attraction : this.alAttraction)
		{
			//header for each attraction
			printWriter.printf("Statistics for Attraction %s\n", attraction.getAttractionID());
			
			printWriter.printf("The total number that got on the ride is %d\n",
								attraction.getAlGotOnRideSize());
			
			//temporary variables
			double averageMinutesFast = 0;
			int numOfFastRiders = 0;
			double averageMinutesNormal = 0;
			int numOfNormalRiders = 0;
			
			//find the num of riders of each type and their average minutes
			for (int index = 0; index < attraction.getAlGotOnRideSize(); index++)
			{
				
				Rider rider = attraction.getGotOnRide(index);
				
				if (rider instanceof FastRider)
				{
					
					numOfFastRiders++;
					
					averageMinutesFast += rider.getTimeOnLine();
					
				}
				else
				{
					
					numOfNormalRiders++;
					
					averageMinutesNormal += rider.getTimeOnLine();
				
				}
				
			}
			
			averageMinutesFast /= numOfFastRiders;
			averageMinutesNormal /= numOfNormalRiders;
			
			//print found data
			printWriter.printf("There were %d Fast Riders who got on waiting "
								+ "on average of %.2f minutes\n",
								numOfFastRiders,
								averageMinutesFast);
			
			printWriter.printf("There were %d Normal Riders who got on waiting "
					+ "on average of %.2f minutes\n",
					numOfNormalRiders,
					averageMinutesNormal);
			
			printWriter.printf("There were %d Total Riders who got on "
					+ "waiting an average of %.2f minutes\n\n\n",
					attraction.getAlGotOnRideSize(),
					(averageMinutesFast + averageMinutesNormal) / 2.0);
			
			
		}
		
	}
	
	
}