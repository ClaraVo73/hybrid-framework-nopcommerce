package com.nopcommerce.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGenerotorManagerFacebook;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class Level_16_Close_Browser extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerotorManagerFacebook.getLoginPage(driver);
    }

    @Test
    public void TC_01_Verify_Element_Displayed(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify Element Email Address Textbox Displayed");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click on Create New Account Button");
        loginPage.clickToCreateNewAccountButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify Email Address Textbox show on popup");
        verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
    }

    @Test
    public void TC_02_Verify_Element_Displayed_In_DOM(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify Element Email Address Textbox Displayed in DOM");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify Email Address Confirm Textbox do not show on Register form");
        verifyFalse(loginPage.isEmailAddressConfirmTextboxDisplayed());
    }

    @Test
    public void TC_03_Verify_Element_Undisplayed_In_DOM(Method method) {
        ExtentTestManager.startTest(method.getName(), "Verify Element Email Address Textbox Undisplayed in DOM");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click on Close Icon At Register form");
        loginPage.clickCloseIconAtRegisterForm();

        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Verify Email Address Confirm Textbox do not show on DOM");
        verifyFalse(loginPage.isConfirmEmailTexboxUndisplayed());

    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

    public int numberRandom() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }

}
