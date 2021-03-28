package project6.simulation;

/*
 * 
 * Name: VehicleClient.java
 * Purpose: Tests the Vehicle classes
 * Author: grivera64
 * 
 */

import java.util.Scanner;

public class VehicleClient
{
	
	//driver (main) method
	public static void main(String[] args)
	{
		
		//create input scanner
		Scanner keyboard = new Scanner(System.in);
		
		//create a motorized vehicle
		MotorizedVehicle mv1 = new MotorizedVehicle();
		
		//request user for vehicle data
		System.out.printf("Please enter the owner name " +
							"for motorized vehicle one in one word: ");
		
		mv1.setOwner(keyboard.next());
		
		keyboard.nextLine();
		
		System.out.printf("Please enter the number of wheels " +
							"for motorized vehicle one as an int: ");
		
		mv1.setWheels(keyboard.nextInt());
		keyboard.nextLine();
		
		System.out.printf("Please enter the volume displacement " +
				"for motorized vehicle one as a double: ");

		mv1.setVolumeDisplacement(keyboard.nextDouble());
		keyboard.nextLine();
		
		System.out.printf("%s\n\n", mv1);
		
		//repeat with second Motorized Vehicle
		
		MotorizedVehicle mv2 = new MotorizedVehicle();
		
		System.out.printf("Please enter the owner name " +
							"for motorized vehicle two in one word: ");
		
		mv2.setOwner(keyboard.next());
		keyboard.nextLine();
		
		System.out.printf("Please enter the number of wheels " +
							"for motorized vehicle two as an int: ");
		
		mv2.setWheels(keyboard.nextInt());
		keyboard.nextLine();
		
		System.out.printf("Please enter the volume displacement " +
				"for motorized vehicle two as a double: ");

		mv2.setVolumeDisplacement(keyboard.nextDouble());
		keyboard.nextLine();
		
		System.out.printf("%s\n\n", mv2);
		
		//compare the vehicles
		
		System.out.printf("mv1 and mv2 %s equal\n", (mv1.equals(mv2)) ? "are" : "are not");
		
		//make the owners match and check equality again
		mv2.setOwner(mv1.getOwner());
		System.out.printf("mv1 and mv2 are %s equal\n", 
						(mv1.equals(mv2)) ? "still" : "still not");
		
		//create a bicycle
		Bicycle b = new Bicycle();
		
		//request user for bicycle data
		System.out.printf("Please enter the owner " +
				"for a bicycle as one word: ");
		
		b.setOwner(keyboard.next());
		keyboard.nextLine();
		
		System.out.printf("Please enter the number of wheels " +
				"for a bicycle as an int: ");
		
		b.setWheels(keyboard.nextInt());
		keyboard.nextLine();
		
		System.out.printf("\n\nb2 is %s\n", b);
		
		
		//close keyboard
		keyboard.close();
		
		//end program
		
	}
	
	
}