package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class Test_Case_Template extends BaseTest {
    private WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }
    @Test
    public void Register_01_Empty_Data() {
       // System.out.println("Home Page - Step 01: Click to Register link");
       // homePage.clickToRegisterLink();
        //Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
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
