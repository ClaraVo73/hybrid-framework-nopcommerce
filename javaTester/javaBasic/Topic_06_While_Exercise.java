package javaBasic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_06_While_DoWhile_Exercise {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01_Even_Numbers() {
        int minNumber = scanner.nextInt();
        while (minNumber <= 100) {
            if (minNumber % 2 == 0) {
                System.out.print(minNumber + " ");
            }
            minNumber++;
        }

    }

    @Test
    public void TC_02_Divisible_3_and_5() {
        int minNumber = scanner.nextInt();
        int maxNumber = scanner.nextInt();
        while (minNumber <= maxNumber) {
            if (minNumber % 3 == 0 && minNumber % 5 == 0) {
                System.out.print(minNumber + " ");
            }
            minNumber++;
        }

    }

    @Test
    public void TC_03_Divisible_3_and_5() {
        int maxNumber = scanner.nextInt();
        int i = 0;
        int sum = 0;
        while (i <= maxNumber) {
            if (!(i % 2 == 0)) {
                sum += i;
            }
            i++;
        } System.out.print("Sum all number form 0 to " +maxNumber+ " is " + sum);

    }

    @Test
    public void TC_04_Divisible_3() {
        int minNumber = scanner.nextInt();
        int maxNumber = scanner.nextInt();
        while (minNumber <= maxNumber) {
            if (minNumber % 3 == 0) {
                System.out.print(minNumber + " ");
            }
            minNumber++;
        }

    }

    @Test
    public void TC_05_Product_of_n() {
        int maxNumber = scanner.nextInt();
        int i = 1;
        int product = 1;
        while (i <= maxNumber) {
            product *=i;
            i++;
        }
        System.out.println("Product all number from 1 to " + maxNumber + " is = " + product);

    }

    @Test
    public void TC_06_Product_of_n() {
        int i = 1;
        while (i <= 10) {
            if (i % 2 == 0){
                System.out.print(i + " ");
            }
            i++;
        }


    }
}
