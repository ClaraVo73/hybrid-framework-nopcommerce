package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;

    }

    public void openPagingByPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
    }

    public void inputToSearchBox(String headerLabel, String value) {
        waitForElementVisible(driver, HomePageUI.SEARCH_HEADER_TEXTBOX, headerLabel);
        sendKeyToElement(driver, HomePageUI.SEARCH_HEADER_TEXTBOX, value, headerLabel);
        pressKeyToElement(driver, HomePageUI.SEARCH_HEADER_TEXTBOX, Keys.ENTER, headerLabel);

    }

    public boolean isPageNumberActived(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
        return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
    }

    public List<String> getValueEachRowAtAllPage() {
        int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);

        List<String> allRowValuesAllPage = new ArrayList<String>();

        //Duyet qua tat ca ca page number (paging)
        for (int index = 1; index <= totalPage; index++) {
            clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
            sleepInSecond(1);

            //Get text tat ca row moi page dua vao Arraylist
            List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
            for (WebElement eachRow: allRowElementEachPage){
                allRowValuesAllPage.add(eachRow.getText());
            }
        }
        //In tat ca gia tri cua tat ca cac page
        for (String value:allRowValuesAllPage){
            System.out.println("----------");
            System.out.println(value);
        }
        return allRowValuesAllPage;
    }
}
