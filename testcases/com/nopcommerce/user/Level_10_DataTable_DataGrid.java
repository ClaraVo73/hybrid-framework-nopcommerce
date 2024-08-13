package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePageTableObject;
import pageObjects.jQuery.PageGeneratorManagerTable;

import java.util.List;
import java.util.Random;

public class Level_10_DataTable_DataGrid extends BaseTest {
    private WebDriver driver;
    private HomePageTableObject homePage;
    List<String> expectedAllValues;
    List<String> actualAllValues;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManagerTable.getHomePage(driver);

    }

    //@Test
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

    //@Test
    public void Table_02_Searching() {
        homePage.refreshCurrentPage(driver);
        homePage.inputToSearchBox("Females", "12253515");
        homePage.inputToSearchBox("Country", "AFRICA");
        homePage.inputToSearchBox("Males", "12599691");
        homePage.inputToSearchBox("Total", "24853148");
        homePage.sleepInSecond(1);

    }

    // @Test
    public void Table_03_Enter_To_Header() {
        //Doc du lieu cua file txt
        // Luu vao vao mot List<String> = expectedAllValues
        actualAllValues = homePage.getValueEachRowAtAllPage();
        Assert.assertEquals(actualAllValues, expectedAllValues);

    }

    @Test
    public void Table_04_Enter_To_Textbox_At_Any_Row() {
        homePage.clickToLoadButton();
        homePage.enterToTextboxAtRowNumberByColumnName("Company","1", "FPT");
        homePage.sleepInSecond(2);

        homePage.enterToTextboxAtRowNumberByColumnName("Contact Person","2", "Vo Thi Ha Ngan");
        homePage.sleepInSecond(2);

        homePage.selectDropdownAtRowNumberByColumnName("Country", "3", "Japan");
        homePage.sleepInSecond(2);

        homePage.enterToTextboxAtRowNumberByColumnName("Order Placed","4", "10");
        homePage.sleepInSecond(2);

        homePage.selectDropdownAtRowNumberByColumnName("Country", "1", "United Kingdom");
        homePage.sleepInSecond(2);

        homePage.checkToCheckboxAtRowNumberByColumnName("NPO?","1");
        homePage.sleepInSecond(2);

        homePage.checkToCheckboxAtRowNumberByColumnName("NPO?","2");
        homePage.sleepInSecond(2);

        homePage.checkToCheckboxAtRowNumberByColumnName("NPO?","3");
        homePage.sleepInSecond(2);

        homePage.uncheckToCheckboxAtRowNumberByColumnName("NPO?","4");
        homePage.sleepInSecond(2);

        homePage.uncheckToCheckboxAtRowNumberByColumnName("NPO?","5");
        homePage.sleepInSecond(2);

        homePage.uncheckToCheckboxAtRowNumberByColumnName("NPO?","6");
        homePage.sleepInSecond(2);

        homePage.clickToIconByRowNumber("1","Insert Row Above");
        homePage.sleepInSecond(2);

        homePage.clickToIconByRowNumber("1","Move Down");
        homePage.sleepInSecond(2);

        homePage.clickToIconByRowNumber("2","Move Up");
        homePage.sleepInSecond(2);

        homePage.clickToIconByRowNumber("1","Remove Current Row");
        homePage.sleepInSecond(2);



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
