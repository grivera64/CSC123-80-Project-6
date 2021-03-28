package project6.lambda;

/*

    Name: TestMYF.java
    Purpose: Tests the MyFunctionalInterface using a lambda expression
    Author: grivera64

*/

import java.util.Scanner;

public class TestMYF
{

	//driver (main) method
    public static void main(String[] args)
    {
    
    	//create input reader
        Scanner keyboard = new Scanner(System.in);
        
        //create lambda expression (anonymous)
        MyFunctionalInterface fiveMore = (num) -> num + 5;
        
        //ask user for number to increment
        for (int i = 0; i < 3; i++)
        {
        
            System.out.printf("Please enter an integer: ");
        
            int num = keyboard.nextInt();
            keyboard.nextLine();
        
            System.out.printf("The integer %d incremented by 5 is %d\n",
                                num, fiveMore.incrementByFive(num));
        
        }
        
        //close input
        keyboard.close();
        
        //terminate program
    
    }

}