package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_02_Apply_BasePage_III extends BasePage{
    WebDriver driver;
    String emailAddress;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        emailAddress = "ara" + numberRandom() + "@mail.hn";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

    }

    @Test
    public void TC_01_Register_Empty_Data() {
        waitForElementVisible(driver, "//a[@class='ico-register']");
       clickToElement(driver, "//a[@class='ico-register']");

        waitForElementVisible(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");


        Assert.assertEquals(getElementText(driver,"//span[@id='FirstName-error']"),"First name is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='LastName-error']"),"Last name is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"),"Email is required.");
        Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"),"Password is required.");

    }

    @Test
    public void TC_02_Register_Invalid_Email() {
        waitForElementVisible(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");

        sendKeyToElement(driver,"//input[@id='FirstName']","Ngan");
        sendKeyToElement(driver,"//input[@id='LastName']","Vo");
        sendKeyToElement(driver,"//input[@id='Email']","clara123@com");
        sendKeyToElement(driver,"//input[@id='Password']","987654321");
        sendKeyToElement(driver,"//input[@id='ConfirmPassword']","987654321");

        waitForElementVisible(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"),"Wrong email");
    }

    @Test
    public void TC_03_Register_Success() {
        waitForElementVisible(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");

        sendKeyToElement(driver,"//input[@id='FirstName']","Ngan");
        sendKeyToElement(driver,"//input[@id='LastName']","Vo");
        sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        sendKeyToElement(driver,"//input[@id='Password']","987654321");
        sendKeyToElement(driver,"//input[@id='ConfirmPassword']","987654321");

        waitForElementVisible(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver,"//div[@class='result']"),"Your registration completed");

        waitForElementVisible(driver, "//a[@class='ico-logout']");
        clickToElement(driver, "//a[@class='ico-logout']");
    }

    @Test
    public void TC_04_Register_Existing_Email() {
        waitForElementVisible(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");


        sendKeyToElement(driver,"//input[@id='FirstName']","Ngan");
        sendKeyToElement(driver,"//input[@id='LastName']","Vo");
        sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        sendKeyToElement(driver,"//input[@id='Password']","987654321");
        sendKeyToElement(driver,"//input[@id='ConfirmPassword']","987654321");

        waitForElementVisible(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver,"//div[contains(@class,'message-error')]//li"),"The specified email already exists");
    }

    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars() {
        waitForElementVisible(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");

        sendKeyToElement(driver,"//input[@id='FirstName']","Ngan");
        sendKeyToElement(driver,"//input[@id='LastName']","Vo");
        sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        sendKeyToElement(driver,"//input[@id='Password']","987");
        sendKeyToElement(driver,"//input[@id='ConfirmPassword']","987");

        waitForElementVisible(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(getElementText(driver,"//span[@class='field-validation-error']"),
                "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void TC_06_Register_Invalid_Confirm_Password() {
        waitForElementVisible(driver, "//a[@class='ico-register']");
        clickToElement(driver, "//a[@class='ico-register']");
        sendKeyToElement(driver,"//input[@id='FirstName']","Ngan");
        sendKeyToElement(driver,"//input[@id='LastName']","Vo");
        sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        sendKeyToElement(driver,"//input[@id='Password']","987654321");
        sendKeyToElement(driver,"//input[@id='ConfirmPassword']","123456789");

        waitForElementVisible(driver, "//button[@id='register-button']");
        clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }

    public int numberRandom() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }
}
