package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.util.Random;

public class Level_03_Page_Object_Login extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private String emailAddress, firstName, lastName, password, unregisteredEmail;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = new HomePageObject(driver);
        loginPage = new LoginPageObject(driver);
        registerPage = new RegisterPageObject(driver);

        firstName = "ngan";
        lastName = "vo";
        password = "987654321";
        emailAddress = "ara" + numberRandom() + "@gmail.vn";
        unregisteredEmail = "clara" + numberRandom() + "@mail.vn";

        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Home Page - Step 02: Input to required fields");
        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        System.out.println("Home Page - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Home Page - Step 04: Verify success message displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        System.out.println("Home Page - Step 03: Click to Register button");
        registerPage.clickToLogoutLink();

    }

    @Test
    public void Login_01_Empty_Data() {
        System.out.println("Login_01_Empty_Data - Step 01: Click to Login link");
        homePage.clickToLoginLink();

        System.out.println("Login_01_Empty_Data - Step 02: Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_01_Empty_Data - Step 03: Verify error message displayed");
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
    }

    @Test
    public void Login_02_Empty_Data() {
        System.out.println("Login_02_Empty_Data - Step 01: Click to Login link");
        homePage.clickToLoginLink();

        System.out.println("Login_02_Empty_Data - Step 02: Input to required field");
        loginPage.inputToEmailTextbox("clara123@com");
        loginPage.inputToPasswordTextbox(password);

        System.out.println("Login_02_Empty_Data- Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_02_Empty_Data - Step 04: Verify error message displayed");
        Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
    }

    @Test
    public void Login_03_Unregistered_Email() {
        System.out.println("Login_03_Unregistered_Email - Step 01: Click to Login link");
        homePage.clickToLoginLink();

        System.out.println("Login_03_Unregistered_Email - Step 02: Input to required field");
        loginPage.inputToEmailTextbox(unregisteredEmail);
        loginPage.inputToPasswordTextbox(password);

        System.out.println("Login_03_Unregistered_Email- Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_02_Empty_Data - Step 04: Verify error message displayed");
        Assert.assertEquals(loginPage.getErrorUnsuccessfullyMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    @Test
    public void Login_04_Empty_Password() {
        System.out.println("Login_04_Empty_Password- Step 01: Click to Login link");
        homePage.clickToLoginLink();

        System.out.println("Login_04_Empty_Password - Step 02: Input to required field");
        loginPage.inputToEmailTextbox(emailAddress);

        System.out.println("Login_04_Empty_Password- Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_04_Empty_Password - Step 04: Verify error message displayed");
        Assert.assertEquals(loginPage.getErrorUnsuccessfullyMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_05_Wrong_Password() {
        System.out.println("Login_05_Wrong_Password - Step 01: Click to Login link");
        homePage.clickToLoginLink();

        System.out.println("Login_05_Wrong_Password - Step 02: Input to required field");
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox("987654");

        System.out.println("Login_04_No_Password- Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_02_Empty_Data - Step 04: Verify error message displayed");
        Assert.assertEquals(loginPage.getErrorUnsuccessfullyMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Test
    public void Login_06_Successfully() {
        System.out.println("Login_06_Successfully - Step 01: Click to Login link");
        homePage.clickToLoginLink();

        System.out.println("Login_06_Successfully - Step 02: Input to required field");
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(password);

        System.out.println("Login_06_Successfully Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        System.out.println("Login_06_Successfully Step 03: Verify my account is displayed");
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
