package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.*;

import java.util.Random;

public class Level_12_Assert_Verify extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;
    private UserRegisterPageObject registerPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private UserAddressesPageObject addressPage;
    private UserMyProductReviewPageObject myProductReviewPage;
    private UserRewardPointsPageObject rewardPointsPage;
    private UserChangePasswordPageObject changePasswordPage;
    private UserDownloadableProductsPageObject downloadableProductsPage;
    private UserBackInStockPageObject backInStockPage;
    private String emailAddress, firstName, lastName, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getUserHomePage(driver);

        firstName = "ngan";
        lastName = "vo";
        password = "987654321";
        emailAddress = "ara" + numberRandom() + "@gmail.vn";
    }

    @Test
    public void User_01_Register_Login() {
        registerPage = homePage.clickToRegisterLink();

        registerPage.inputToFirstnameTextbox(firstName);
        registerPage.inputToLastnameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

        homePage = registerPage.clickToLogoutLink();
        loginPage = homePage.clickToLoginLink();

        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(password);

        homePage = loginPage.clickToLoginButton();
        verifyFalse(homePage.isMyAccountLinkDisplayed());

        customerInfoPage = homePage.clickToMyAccountLink();
        verifyTrue(customerInfoPage.isCustomerInfoPageDisplayed());
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
