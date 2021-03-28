package project6.lambda;

/*

    Name: TestMYF.java
    Purpose: Tests the MyFunctionalInterface using a lambda expression
    Author: grivera64

*/

import java.util.Scanner;

public class TestMYF
{

    public static void main(String[] args)
    {
    
        Scanner keyboard = new Scanner(System.in);
        
        MyFunctionalInterface fiveMore = (num) -> num + 5;
        
        for (int i = 0; i < 3; i++)
        {
        
            System.out.printf("Please enter an integer: ");
        
            int num = keyboard.nextInt();
            keyboard.nextLine();
        
            System.out.printf("The integer %d incremented by 5 is %d\n",
                                num, fiveMore.incrementByFive(num));
        
        }
        
        keyboard.close();
        
    
    }

}