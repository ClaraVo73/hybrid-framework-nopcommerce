package javaBasic;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_08_Array_Exercise {
    Scanner scanner = new Scanner(System.in);

    @Test
    public void TC_01_Largest_Numbers() {
        int[] arr = {2,7,6,8,9};

        int max = arr[0];

        for (int i=1; i < arr.length; i ++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Max number is " + max);
    }

    @Test
    public void TC_02_Largest_Numbers() {
        int[] arr = {2,7,6,8,9, 1000};
         if(arr.length > 0){
            int sum = arr[0] + arr[arr.length -1];
            System.out.println("The sum of the first and last elements is " + sum);
        }else System.out.println("No elements in array." );


    }

    @Test
    public void TC_03_Even_Numbers() {
        int[] arr = {2,7,6,8,9,17,20,30,31,32,33};
        for(int i = 0; i < arr.length; i++){
            if (arr[i] % 2 == 0){
                System.out.print(arr[i]+ " ");
            }
        }


    }

    @Test
    public void TC_04_Sum_Old_Numbers() {
        int[] arr = {2,7,6,8,9,17,20,30,31,32,33,0};
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if (!(arr[i] % 2 == 0) && arr[i] > 0){
                sum += arr[i];
            }
        } System.out.print("Sum of old numbers grater than 0 in array: " +sum);
    }

    @Test
    public void TC_05_Print_0_10_Numbers() {
        int[] arr = {2,7,6,8,9,17,20,30,31,32,33,0,-5};
        for( int i = 0; i < arr.length; i++){
            if (arr[i] >= 0 && arr[i] <= 10){
                System.out.print(arr[i] + " ");
            }
        }
    }

    @Test
    public void TC_06_Print_0_10_Numbers() {
        int[] arr = {2,7,6,8,9,-17,20};
        int sum = 0;
        int average = 0;
        for( int i = 0; i < arr.length; i++){
          sum += arr[i];
          average = sum / arr.length;

        }
        System.out.println("Sum all number in array = " +sum);
        System.out.println("Average all number in array = " +average);
    }
}
