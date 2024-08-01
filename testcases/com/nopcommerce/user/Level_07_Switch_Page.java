package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.Random;

public class Level_07_Switch_Page extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private RegisterPageObject registerPage;
    private CustomerInfoPageObject customerInfoPage;
    private AddressesPageObject addressPage;
    private MyProductReviewPageObject myProductReviewPage;
    private RewardPointsPageObject rewardPointsPage;
    private String emailAddress, firstName, lastName, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);

        firstName = "ngan";
        lastName = "vo";
        password = "987654321";
        emailAddress = "ara" + numberRandom() + "@gmail.vn";
    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        homePage = registerPage.clickToLogoutLink();
    }

    @Test
    public void User_02_Login() {
        loginPage = homePage.clickToLoginLink();

        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_CustomerInfo() {
        customerInfoPage = homePage.clickToMyAccountLink();
        Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
    }

    @Test
    public void User_04_Switch_Page() {
        //Customer page to address page
        addressPage = customerInfoPage.openAddressPage(driver);

        //Address page to My product review page
        myProductReviewPage = addressPage.openMyProductReviewPage(driver);

        // My product review page to reward point page
        rewardPointsPage = myProductReviewPage.openRewardPointsPage(driver);

        // Reward point page to Customer info page
        customerInfoPage = rewardPointsPage.openCustomerInfoPage(driver);
    }

    @Test
    public void User_04_Switch_Role() {

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
