package javaBasic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_07_Break_Continue_Exercise {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01_Even_Numbers() {
        String browserName = scanner.nextLine();
        if (!browserName.equals("ie")) {
            System.out.println("Browser name is = " + browserName);
        } else System.out.println("Browser name IE so quit");
        scanner.close();
    }

    @Test
    public void TC_02_Month() {
        int month = scanner.nextInt();

        switch (month){
            case 1:
                System.out.println("JAN");
                break;
            case 2:
                System.out.println("FEB");
                break;
            case 3:
                System.out.println("MAR");
                break;
            case 4:
                System.out.println("APR");
                break;
            case 5:
                System.out.println("MAY");
                break;
            case 6:
                System.out.println("JUN");
                break;
            case 7:
                System.out.println("JUL");
                break;
            case 8:
                System.out.println("AUG");
                break;
            case 9:
                System.out.println("SEP");
                break;
            case 10:
                System.out.println("OCT");
                break;
            case 11:
                System.out.println("NOV");
                break;
            case 12:
                System.out.println("DEC");
                break;

        }




    }


}
