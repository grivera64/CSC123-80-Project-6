package project6.park;


import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class SimulatePark
{
	
	public static void main(String[] args) throws IOException
	{
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.printf("Please enter the name of the Amusement Park: ");
		
		String name = keyboard.nextLine();
		
		System.out.printf("Please enter the number of attractions\n");
		
		int numOfAttractions = 0;
		do
		{
			
			System.out.printf("Number must be between 3 and 10 inclusively, excluding 7: ");
			numOfAttractions = keyboard.nextInt();
			keyboard.nextLine();
			
		} while(!(numOfAttractions >= 3 && numOfAttractions <= 10 && numOfAttractions != 7));
		
		AmusementPark park = new AmusementPark(name, numOfAttractions);
		
		
		int duration = 0;
		do
		{
			
			System.out.printf("Please enter the duration of the simulation in minutes: ");
		
			duration = keyboard.nextInt();
			keyboard.nextLine();
			
		} while (duration < 60);
		
		park.runThePark(duration);
		
		String fileName;
		
		System.out.printf("Please enter the name of the output file:\n");
		
		fileName = keyboard.next();
		keyboard.nextLine();
		File file = new File(fileName);
		PrintWriter printWriter = new PrintWriter(file);
		
		park.printParkStatistics(printWriter);
		
		printWriter.close();
		keyboard.close();
		
	}
	
}