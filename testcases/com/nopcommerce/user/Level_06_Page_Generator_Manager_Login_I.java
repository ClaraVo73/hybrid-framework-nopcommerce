package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;

import java.util.Random;

public class Level_06_Page_Generator_Manager_Login_I extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserRegisterPageObject registerPage;
    private String emailAddress, firstName, lastName, password, unregisteredEmail;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = new UserHomePageObject(driver);

        firstName = "ngan";
        lastName = "vo";
        password = "987654321";
        emailAddress = "ara" + numberRandom() + "@gmail.vn";
        unregisteredEmail = "clara" + numberRandom() + "@mail.vn";

        homePage.clickToRegisterLink();

        registerPage = new UserRegisterPageObject(driver);

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        registerPage.clickToLogoutLink();

        homePage = new UserHomePageObject(driver);

    }

    @Test
    public void Login_01_Empty_Data() {
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
    }

    @Test
    public void Login_02_Empty_Data() {
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.inputToEmailTextbox("clara123@com");
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
    }

    @Test
    public void Login_03_Unregistered_Email() {
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.inputToEmailTextbox(unregisteredEmail);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorUnsuccessfullyMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void Login_04_Empty_Password() {
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorUnsuccessfullyMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_05_Wrong_Password() {
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox("987654");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorUnsuccessfullyMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_06_Successfully() {
        homePage.clickToLoginLink();

        loginPage = new UserLoginPageObject(driver);

        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(password);
        loginPage.clickToLoginButton();

        homePage = new UserHomePageObject(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

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
