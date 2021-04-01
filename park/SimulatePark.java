package project6.park;

/*
 * 
 * Name: SimulatePark.java
 * Purpose: Runs the simulation
 * Author: grivera64
 * 
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class SimulatePark
{
	
	public static void main(String[] args) throws IOException
	{
		
		//allows input from terminal
		Scanner keyboard = new Scanner(System.in);
		
		//request user for name of park
		System.out.printf("Please enter the name of the Amusement Park: ");
		String name = keyboard.nextLine();
		
		//request for the num of attractions from user
		System.out.printf("Please enter the number of attractions\n");
		
		//loop until the provided data is within 3 and 10 inclusive excluding 7
		int numOfAttractions = 0;
		do
		{
			
			System.out.printf("Number must be between 3 and 10 inclusively, excluding 7: ");
			numOfAttractions = keyboard.nextInt();
			keyboard.nextLine();
			
		} while(!(numOfAttractions >= 3 && numOfAttractions <= 10 && numOfAttractions != 7));
		
		//create the park
		AmusementPark park = new AmusementPark(name, numOfAttractions);
		
		//ask user for the duration of the simulation (loop until is 60+ minutes)
		int duration = 0;
		do
		{
			
			System.out.printf("Please enter the duration of the simulation in minutes: ");
		
			duration = keyboard.nextInt();
			keyboard.nextLine();
			
		} while (duration < 60);
		
		//run the park
		park.runThePark(duration);
		
		//request the user for a file to write to
		String fileName;		
		System.out.printf("Please enter the name of the output file:\n");
		fileName = keyboard.next();
		keyboard.nextLine();
		
		//create the file if it doesn't exist and make a writing connection to it
		File file = new File(fileName);
		PrintWriter printWriter = new PrintWriter(file);
		
		//print the statistics to the file provided
		park.printParkStatistics(printWriter);
		
		//close the scanner and print writer
		printWriter.close();
		keyboard.close();
		
		//terminate program
		
	}
	
}