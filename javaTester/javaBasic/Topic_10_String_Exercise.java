package javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_10_String_Exercise {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
       // WebDriver driver = new FirefoxDriver();
        String schoolname = "Automation Testing";
        String courseName = "AUTOMATION TESTING";
        String schoolAddress = " Ho Chi Minh city";

        System.out.println("Length = " + schoolname.length());
        System.out.println("Get a character in string = " + schoolname.charAt(1));
        System.out.println("Connect 2 strings =  = " + schoolname.concat(schoolAddress));

        //absolutely
        System.out.println("Check 2 string are absolutely equal  =  = " + schoolname.equals(courseName));
        System.out.println("Check 2 string are absolutely equal  =  = " + schoolname.equals("Automation Testing"));

        //Multi browser
        System.out.println("Check 2 string are relatively equal  =  = " + schoolname.equalsIgnoreCase(courseName));

        //starsWith /endsWith/ contains
        System.out.println(" Start by a character/string = " + schoolname.startsWith("A"));
        System.out.println(" Start by a character/string = " + schoolname.startsWith("Automation"));
        System.out.println(" Start by a character/string = " + schoolname.startsWith("a"));

        System.out.println(" Contains a character/string = " + schoolname.contains("Testing"));
        System.out.println(" End by a character/string = " + schoolname.endsWith("g"));

        System.out.println(" Position of charrater/string = " + schoolname.indexOf("A"));
        System.out.println(" Split  charrater/string = " + schoolname.substring(5));

        //split 48 from string
        String result = "Viewing 48 of 132 result";
        String results[] = result.split(" ");
        System.out.println(results[1]);

        //Replace
        String productPrice = "$100.00";
        productPrice = productPrice.replace("$", "");
        System.out.println(productPrice);

        // Need to sort data (Asc/Desc)
        float productPriceF = Float.parseFloat(productPrice);
        System.out.println(productPriceF);

        productPrice = String.valueOf(productPriceF);
        System.out.println(productPrice);

     /*   String osName = System.getProperty("os.name");
        System.out.println(osName);*/
        //Windows 10
        // handle multiple OS: MAC/Windows (action - keys -Ctrl/Command)
        /*if(osName.toLowerCase().contains("windows")){
            Keys key = Keys.CONTROL;
        }else {
            Keys key = Keys.COMMAND;
        }*/
        //Multiple browser: toUpperCase
        // firefox = FIREFOX (Enum)

        /*String driverInstanceName = driver.toString();
        System.out.println(driverInstanceName);*/
        //FirefoxDriver: firefox on WINDOWS (377efdfc-7cd3-423a-abee-1dbc579b4e99)

        String helloWorld = " \n \t  Hello Chip and Mun! ";
        System.out.println(helloWorld);
        System.out.println(helloWorld.trim());

        helloWorld = " ";
        System.out.println("Empty = " + helloWorld.isEmpty());
        System.out.println("Blank = " + helloWorld.isBlank());


    }

    @Test
    public void TC_01_Count_UpperCase(){
        String courseName = "Automation FC";

        int number = 0 ;
        for (int i = 0 ; i< courseName.length(); i++){
            char characterUpperCase = courseName.charAt(i);
            if (Character.isUpperCase(characterUpperCase)){
                number++;
            }
        }
        System.out.println("Number of uppercase characters = " + number);
    }

    @Test
    public void TC_02_Digit(){
        String courseName = "Automation Testing 345 Tutories Online 789aA";

        int number = 0 ;
        for (int i = 0 ; i< courseName.length(); i++){
            if (courseName.charAt(i)== 'a' || courseName.charAt(i)== 'A'){
                number++;
            }
        }
        System.out.println("Number of 'a' characters in string= " + number);
        System.out.println("Contains 'Testing' in string: " + courseName.contains("Testing"));
        System.out.println("Start with 'Automation' in string: " + courseName.startsWith("Automation"));
        System.out.println("End with 'Online' in string: " + courseName.endsWith("Online"));
        System.out.println("Get position of 'Tutories' in string: " + courseName.indexOf("Tutories"));

        courseName = courseName.replace("Online","Offline");
        System.out.println("String afer replace: " + courseName);

        int numberIsNumber = 0 ;
        for (int i = 0 ; i< courseName.length(); i++){
            char characterNumber = courseName.charAt(i);
            if (Character.isDigit(characterNumber)){
                numberIsNumber++;
            }
        }
        System.out.println("Number of characters is Number in string= " + numberIsNumber);




    }

    @Test
    public void TC_03_Reverse_String(){
        String courseName = "Automation FC";
        StringBuilder reversed = new StringBuilder(courseName);
        reversed.reverse();
        String reversedString = reversed.toString();
        System.out.println("Reversed string: " + reversedString);

    }

    @Test
    public void TC_04_Phone_Number(){
        String phoneNumber = scanner.nextLine().trim();

        if(phoneNumber.length() == 10){
            char firstNumber = phoneNumber.charAt(0);
                if (firstNumber == '7' || firstNumber == '8' || firstNumber == '9'){
                    System.out.println("The phone number is correct format");
                }else{
                    System.out.println("The phone number is incorrect format");
                }
        }else {
            System.out.println("The phone number is incorrect format");
        }
        scanner.close();


    }



}
