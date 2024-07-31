package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.RegisterPageFactory;

import java.util.Random;

public class Level_05_Page_Factory_Register extends BaseTest {
    private WebDriver driver;
    private String emailAddress, firstName, lastName, password;
    private HomePageFactory homePage;
    private RegisterPageFactory registerPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = new HomePageFactory(driver);
        registerPage = new RegisterPageFactory(driver);

        firstName = "ngan";
        lastName = "vo";
        password = "987654321";
        emailAddress = "ara" + numberRandom() + "@mail.com";
    }

    @Test
    public void Register_01_Empty_Data() {
        homePage.clickToRegisterLink();
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        homePage.clickToRegisterLink();

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox("clara123@com");
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
    }

    @Test
    public void Register_03_Success() {
        homePage.clickToRegisterLink();

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        registerPage.clickToLogoutLink();
    }

    @Test
    public void Register_04_Existing_Email() {
        homePage.clickToRegisterLink();

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
    }

    @Test
    public void Register_05_Password_Less_Than_6_Chars() {
        homePage.clickToRegisterLink();

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox("987");
        registerPage.inputToConfirmPasswordTextbox("987");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getValidationErrorMessageAtPasswordTextbox(),
                "<p>Password must meet the following rules: </p><ul><li>must have at least 6 characters and not greater than 64 characters</li></ul>");

    }

    @Test
    public void Register_06_Invalid_Confirm_Password() {
        homePage.clickToRegisterLink();

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox("123456789");

        registerPage.clickToRegisterButton();

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
