package javaBasic;

import org.testng.annotations.Test;

public class Topic_01_Data_Type_Exercise {
   @Test
    public void TC_01_Math(){
       int a = 6;
       int b = 2;
       System.out.println("Sum is = " + (a+b));
       System.out.println("Difference is = " + (a-b));
       System.out.println("Product is = " + (a*b));
       System.out.println("Quotient is = " + (a/b));

   }

    @Test
    public void TC_02_Area(){
        float a = 7.5f;
        float b = 3.8f;
        System.out.println("Area is = " + (a*b));
    }

    @Test
    public void TC_03_Hello(){
        String name = "Automation Testing";
        System.out.println("Hello " + name);
    }
}
