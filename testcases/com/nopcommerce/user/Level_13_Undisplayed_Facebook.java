package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGenerotorManagerFacebook;
import pageObjects.user.*;

import java.util.Random;

public class Level_13_Undisplayed_Facebook extends BaseTest {
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
        loginPage.clickToCreateNewAccountButton();
        verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
    }

    @Test
    public void TC_02_Verify_Element_Undisplayed_In_DOM() {
        verifyFalse(loginPage.isEmailAddressConfirmTextboxDisplayed());
    }

    @Test
    public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
        loginPage.clickCloseIconAtRegisterForm();
        verifyTrue(loginPage.isConfirmEmailTexboxUndisplayed());

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public int numberRandom() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }

}
