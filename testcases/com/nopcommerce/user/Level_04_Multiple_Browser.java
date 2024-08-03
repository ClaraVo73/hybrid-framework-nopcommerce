package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserRegisterPageObject;

import java.util.Random;

public class Level_04_Multiple_Browser extends BaseTest {
    private WebDriver driver;
    private String emailAddress, firstName, lastName, password;
    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = new UserHomePageObject(driver);
        registerPage = new UserRegisterPageObject(driver);
        firstName = "ngan";
        lastName = "vo";
        password = "987654321";
        emailAddress = "ara" + numberRandom() + "@mail.hn";
    }

    @Test
    public void Register_01_Empty_Data() {
        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Home Page - Step 02: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Home Page - Step 03: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Home Page - Step 02: Input to required fields");
        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox("clara123@com");
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        System.out.println("Home Page - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Home Page - Step 03: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
    }

    @Test
    public void Register_03_Success() {
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
    public void Register_04_Existing_Email() {
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
        Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
    }

    @Test
    public void Register_05_Password_Less_Than_6_Chars() {
        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Home Page - Step 02: Input to required fields");
        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox("987");
        registerPage.inputToConfirmPasswordTextbox("987");

        System.out.println("Home Page - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Home Page - Step 04: Verify error message displayed");
        Assert.assertEquals(registerPage.getValidationErrorMessageAtPasswordTextbox(),
                "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

    }

    @Test
    public void Register_06_Invalid_Confirm_Password() {
        System.out.println("Home Page - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("Home Page - Step 02: Input to required fields");
        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox("123456789");

        System.out.println("Home Page - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("Home Page - Step 04: Verify error message displayed");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
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
