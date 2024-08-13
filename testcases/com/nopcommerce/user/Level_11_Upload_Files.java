package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePageUploadFileObject;
import pageObjects.jQuery.PageGeneratorManagerUploadFile;

import java.util.Random;

public class Level_11_Upload_Files extends BaseTest {
    private WebDriver driver;
    private HomePageUploadFileObject homePage;
    String beachFileName = "beach.jpg";
    String sunFileName = "sun.jpg";
    String townFileName = "town.jpg";
    String[] multipleFileNames = {beachFileName,sunFileName,townFileName};


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManagerUploadFile.getHomePage(driver);
    }

    @Test
    public void Upload_01_One_File_Per_Time() {
        homePage.uploadMultipleFiles(driver,beachFileName);
        Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));
        homePage.clickToStartButton();
        Assert.assertTrue(homePage.isFileUpLoadedByName(beachFileName));
        Assert.assertTrue(homePage.isFileImageUpLoadedByName(beachFileName));
    }

    @Test
    public void Upload_01_Multiple_File_Per_Time() {
        homePage.refreshCurrentPage(driver);
        homePage.uploadMultipleFiles(driver,multipleFileNames);
        Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));
        Assert.assertTrue(homePage.isFileLoadedByName(sunFileName));
        Assert.assertTrue(homePage.isFileLoadedByName(townFileName));
        homePage.clickToStartButton();
        Assert.assertTrue(homePage.isFileUpLoadedByName(beachFileName));
        Assert.assertTrue(homePage.isFileUpLoadedByName(sunFileName));
        Assert.assertTrue(homePage.isFileUpLoadedByName(townFileName));

        Assert.assertTrue(homePage.isFileImageUpLoadedByName(beachFileName));
        Assert.assertTrue(homePage.isFileImageUpLoadedByName(sunFileName));
        Assert.assertTrue(homePage.isFileImageUpLoadedByName(townFileName));

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
