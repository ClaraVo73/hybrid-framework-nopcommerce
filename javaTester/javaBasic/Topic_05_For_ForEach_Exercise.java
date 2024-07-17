package javaBasic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_05_For_ForEach_Exercise {
    WebDriver driver;
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01_Print_1_n() {
        int maxNumber = scanner.nextInt();

        for (int i = 1; i <= maxNumber; i++) {
            System.out.print(i + " ");
        }
        //Ve 1: bien tam dung de tang gia tri len sau moi lan quyet. Dung de so sanh voi tong gia tri
        //Ve 2: So sanh voi tong
        //Ve 3: tang i len 1 don vi sau khi chay vao than vong for

    }

    @Test
    public void TC_02_Print_a_b() {
        int minNumber = scanner.nextInt();
        int maxNumber = scanner.nextInt();

        for (int i = minNumber; i <= maxNumber; i++) {
            System.out.print(i + " ");
        }

    }

    @Test
    public void TC_03_Even_Number() {

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }

        }

    }

    @Test
    public void TC_04_Sum_All_Number() {
        int minNumber = scanner.nextInt();
        int maxNumber = scanner.nextInt();
        int sum = 0;

        for (int i = minNumber; i <= maxNumber; i++) {
            sum += i;
        }
        System.out.println("Sum all number from " + minNumber + " to " + maxNumber + " is = " + sum);
    }

    @Test
    public void TC_05_Sum_All_0_n() {
        int maxNumber = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i <= maxNumber; i++) {
            sum += i;
        }
        System.out.println("Sum all number from 0 to " + maxNumber + " is = " + sum);
    }

    @Test
    public void TC_06_Divisible_by_3() {
        int minNumber = scanner.nextInt();
        int maxNumber = scanner.nextInt();

        for (int i = minNumber; i <= maxNumber; i++) {
            if (i % 3 == 0){
                System.out.print(i + " ");
            }
        }
    }

    @Test
    public void TC_07_Product_All_Number() {
        int maxNumber = scanner.nextInt();
        int product = 1;

        for (int i = 1; i <= maxNumber; i++) {
            product *= i;
        }
        System.out.println("Product all number from 1 to " + maxNumber + " is = " + product);
    }

    @Test
    public void TC_10_City() {
        String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong", "Khanh Hoa"};
        for (int i = 0; i < cityName.length; i++) {
            if (cityName[i].equals("Da Nang")) {
                System.out.println("Do action!");
                break;
            }
        }

    }


}
