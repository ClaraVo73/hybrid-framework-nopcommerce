package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

import java.util.Random;

public class Level_10_DataTable_DataGrid extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);

    }

    @Test
    public void Table_01_Paging() {
        homePage.openPagingByPageNumber("1");
        homePage.sleepInSecond(1);
        Assert.assertTrue(homePage.isPageNumberActived("1"));


        homePage.openPagingByPageNumber("10");
        homePage.sleepInSecond(1);
        Assert.assertTrue(homePage.isPageNumberActived("10"));

        homePage.openPagingByPageNumber("18");
        homePage.sleepInSecond(1);
        Assert.assertTrue(homePage.isPageNumberActived("18"));

        homePage.openPagingByPageNumber("9");
        homePage.sleepInSecond(1);
        Assert.assertTrue(homePage.isPageNumberActived("9"));



    }
    @Test
    public void Table_02_Searching() {
        homePage.refreshCurrentPage(driver);
        homePage.inputToSearchBox("Females","12253515");
        homePage.inputToSearchBox("Country","AFRICA");
        homePage.inputToSearchBox("Males","12599691");
        homePage.inputToSearchBox("Total","24853148");
        homePage.sleepInSecond(1);

    }

    @Test
    public void Table_03_Enter_To_Header() {
      homePage.getValueEachRowAtAllPage();

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
