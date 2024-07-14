package javaBasic;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Topic_02_Operator_Exercise {
   @Test
    public void TC_01_Name_Old(){
       String name = "Ngan";
       int old = 32;

       System.out.println("After 15 year, age of " + name + " will be " + (old+15));
   }

    @Test
    public void TC_02_Swap(){
       int a = 8;
       int b = 2;

       a = a + b; //result: a = 10 ,b =2
       b = a - b; //result: a = 10 ,b =8
       a= a - b; //result: a = 2 ,b =8
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    @Test
    public void TC_03_Compare(){
       int a = 5;
       int b = 4;

       if (a > b) {
           System.out.println("true");
       }else System.out.println("false");

    }
}
