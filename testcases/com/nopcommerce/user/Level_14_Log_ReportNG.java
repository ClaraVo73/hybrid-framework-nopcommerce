package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGenerotorManagerFacebook;

import java.util.Random;

public class Level_14_Log_ReportNG extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        loginPage = PageGenerotorManagerFacebook.getLoginPage(driver);
    }

    @Test
    public void TC_01_Verify_Element_Displayed() {
        log.info("Verify_Element_Displayed - Step 01: Click on Create New Account Button");
        loginPage.clickToCreateNewAccountButton();

        log.info("Verify_Element_Displayed - Step 02: Verify Email Address Textbox show on popup");
        verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
    }

    @Test
    public void TC_02_Verify_Element_Undisplayed_In_DOM() {
        log.info("Verify_Element_Undisplayed_In_DOM - Step 01: Verify Email Address Confirm Textbox do not show on Register form");
        verifyFalse(loginPage.isEmailAddressConfirmTextboxDisplayed());
    }

    @Test
    public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
        log.info("Verify_Element_Undisplayed_Not_In_DOM - Step 02: Click on Close Icon At Register form");
        loginPage.clickCloseIconAtRegisterForm();

        log.info("Verify_Element_Undisplayed_Not_In_DOM - Step 01: Verify Email Address Confirm Textbox do not show on DOM");
        verifyTrue(loginPage.isConfirmEmailTexboxUndisplayed());

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
