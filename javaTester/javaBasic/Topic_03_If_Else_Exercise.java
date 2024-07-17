package javaBasic;

import org.testng.annotations.Test;
import java.util.Scanner;

public class Topic_03_If_Else_Exercise {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01_Old_Even_Number() {
        System.out.print("Input numbers: ");
        int number = scanner.nextInt();

        if (number % 2 == 0){
            System.out.println(number + " is old");
        }else System.out.println(number + " is even");
        scanner.close();
    }

    @Test
    public void TC_02_Compare_Number() {
        int aNumber = scanner.nextInt();
        int bNumber = scanner.nextInt();

        if (aNumber >= bNumber){
            System.out.println( aNumber + " greater than or equal to " + bNumber);
        }else System.out.println( aNumber + " less than " + bNumber);
        scanner.close();
    }
    @Test
    public void TC_03_Compare_Number() {
        String firstPerson = scanner.nextLine();
        String secondPerson = scanner.nextLine();

        if (firstPerson.equals(secondPerson)){
            System.out.println( "Two people have the same names");
        }else System.out.println( "Two people have the different names");
        scanner.close();
    }

    @Test
    public void TC_04_Largest_Number() {
        int aNumber = scanner.nextInt();
        int bNumber = scanner.nextInt();
        int cNumber = scanner.nextInt();

        if (aNumber > bNumber && aNumber > cNumber){
            System.out.println( aNumber +  " is the largest number");
        }else if (bNumber > aNumber && bNumber > cNumber){
            System.out.println( bNumber +  " is the largest number");
        }else  System.out.println( cNumber +  " is the largest number");

        scanner.close();
    }

    @Test
    public void TC_05_Range_Number() {
        int number = scanner.nextInt();

        if ( 10 < number &&  number < 100) {
            System.out.println(number + " is in the range [10,100]");
        } else System.out.println(number + " is not in the range [10,100]");

        scanner.close();
    }

    @Test
    public void TC_06_Scores() {
        float score = scanner.nextFloat();

      if (8.5 <= score && score <= 10){
          System.out.println(" A score");
      }else if (7.5 <= score && score < 8.5){
          System.out.println(" B score");
      }else if (5 <= score && score < 7.5){
          System.out.println(" C score");
      }else if (0 <= score && score < 5){
          System.out.println(" C score");
      }else System.out.println(" Please enter score again!");
        scanner.close();
    }

    @Test
    public void TC_07_Month() {
        int month = scanner.nextInt();

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            System.out.println("This month has 31 days");
        }else if (month == 4 || month == 6 || month == 9 || month == 11){
            System.out.println("This month has 30 days");
        }else System.out.println("This month has 29 days");

        scanner.close();
    }


}
