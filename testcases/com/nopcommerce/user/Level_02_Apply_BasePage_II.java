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

public class Level_02_Apply_BasePage_II {
    WebDriver driver;
    String emailAddress;
    BasePage basePage;
    String projectPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        basePage = BasePage.getBasePageObject();

        emailAddress = "ara" + numberRandom() + "@mail.hn";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

    }

    @Test
    public void TC_01_Register_Empty_Data() {
        basePage.waitForElementVisible(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.waitForElementVisible(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");


        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='FirstName-error']"),"First name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='LastName-error']"),"Last name is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"),"Email is required.");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"),"Password is required.");

    }

    @Test
    public void TC_02_Register_Invalid_Email() {
        basePage.waitForElementVisible(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver,"//input[@id='FirstName']","Ngan");
        basePage.sendKeyToElement(driver,"//input[@id='LastName']","Vo");
        basePage.sendKeyToElement(driver,"//input[@id='Email']","clara123@com");
        basePage.sendKeyToElement(driver,"//input[@id='Password']","987654321");
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']","987654321");

        basePage.waitForElementVisible(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"),"Wrong email");
    }

    @Test
    public void TC_03_Register_Success() {
        basePage.waitForElementVisible(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver,"//input[@id='FirstName']","Ngan");
        basePage.sendKeyToElement(driver,"//input[@id='LastName']","Vo");
        basePage.sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id='Password']","987654321");
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']","987654321");

        basePage.waitForElementVisible(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"),"Your registration completed");

        basePage.waitForElementVisible(driver, "//a[@class='ico-logout']");
        basePage.clickToElement(driver, "//a[@class='ico-logout']");
    }

    @Test
    public void TC_04_Register_Existing_Email() {
        basePage.waitForElementVisible(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");


        basePage.sendKeyToElement(driver,"//input[@id='FirstName']","Ngan");
        basePage.sendKeyToElement(driver,"//input[@id='LastName']","Vo");
        basePage.sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id='Password']","987654321");
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']","987654321");

        basePage.waitForElementVisible(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//div[contains(@class,'message-error')]//li"),"The specified email already exists");
    }

    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars() {
        basePage.waitForElementVisible(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendKeyToElement(driver,"//input[@id='FirstName']","Ngan");
        basePage.sendKeyToElement(driver,"//input[@id='LastName']","Vo");
        basePage.sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id='Password']","987");
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']","987");

        basePage.waitForElementVisible(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//span[@class='field-validation-error']"),
                "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");
    }

    @Test
    public void TC_06_Register_Invalid_Confirm_Password() {
        basePage.waitForElementVisible(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.sendKeyToElement(driver,"//input[@id='FirstName']","Ngan");
        basePage.sendKeyToElement(driver,"//input[@id='LastName']","Vo");
        basePage.sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id='Password']","987654321");
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']","123456789");

        basePage.waitForElementVisible(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

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
