package com.nopcommerce.user;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import commons.PageGeneratorManager;

import java.util.Random;

public class Level_08_Switch_Role extends BaseTest {
    private WebDriver driver;
    private UserHomePageObject userHomePage;
    private UserLoginPageObject userLoginPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminDashboardPageObject adminDashboardPage;
    private UserCustomerInfoPageObject userCustomerInfoPage;
    private String userEmail, userPassword, adminEmail, adminPassword;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowserDriver(browserName,environmentName);
        userHomePage = PageGeneratorManager.getUserHomePage(driver);

        userEmail = "na78945@mail.vn";
        userPassword = "123456";
        adminEmail = "admin@yourstore.com";
        adminPassword = "admin";
    }

    @Test
    public void Role_01_User_To_Admin() {
        userLoginPage = userHomePage.openLoginPage(driver);

        //Login as user
        userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

        //Home page -> Customer info page
        userCustomerInfoPage = userHomePage.clickToMyAccountLink();

        //Customer info page -> click logout -> Home page
        userHomePage = userCustomerInfoPage.clickToLogoutLinkAsUser(driver);

        //Home page as user -> open admin page -> login as admin
        userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PRODUCTION_URL);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

        //Login as admin
        adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
        Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

        //Logout as admin
        adminLoginPage =adminDashboardPage.clickToLogoutLinkAsAdmin(driver);

    }

    @Test
    public void Role_02_Admin() {
        //login page of admin -> open user page
       adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PRODUCTION_URL);
       userHomePage = PageGeneratorManager.getUserHomePage(driver);

       //Login user
        userLoginPage = userHomePage.openLoginPage(driver);
        userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());


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
