package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_04_Switch_Case_Exercise {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    Scanner scanner = new Scanner(System.in);


    @Test
    public void TC_01_English_Number() {
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Nine");
                break;
            case 10:
                System.out.println("Ten");
                break;
            default:
                System.out.println("Only enter 1 to 10");
                break;
        }
        scanner.close();

    }

    @Test
    public void TC_02_Math() {
        String operator = scanner.nextLine();

        int aNumber = scanner.nextInt();
        int bNumber = scanner.nextInt();

        switch (operator){
            case "+":
                System.out.println("A + B = " + (aNumber + bNumber));
                break;
            case "-":
                System.out.println("A - B = " + (aNumber - bNumber));
                break;
            case "*":
                System.out.println("A * B = " + (aNumber * bNumber));
                break;
            case "/":
                System.out.println("A / B = " + (aNumber / bNumber));
                break;
            case "%":
                System.out.println("A % B = " + (aNumber % bNumber));
                break;

        }


        scanner.close();

    }



    @Test
    public void TC_03_Month() {
        int month = scanner.nextInt();

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("This month has 31 days");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("This month has 30 days");
                break;
            case 2:
                System.out.println("This month has 29 days");
                break;
            default:
                System.out.println("This month is incorrect format");
                break;
        }
        scanner.close();
    }

    @Parameters("browser")// se duoc goi khi chay file xml
    @Test
    public void TC_04_Browser(String browserName) {
        driver = getBrowserDriver(browserName);
        System.out.println(browserName);

        driver.quit();
    }

    public WebDriver getBrowserDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
                new RuntimeException("Please input correct the browser name!");
                break;
        }
        return driver;
    }


}
