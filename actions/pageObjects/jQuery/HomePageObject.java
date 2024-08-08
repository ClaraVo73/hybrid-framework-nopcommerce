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

    public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String valueToEnter) {
        //Lay ra column index dua vao ten cot
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
        //Senkey vao dong nao
        waitForElementVisible(driver, HomePageUI.CELL_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
        sendKeyToElement(driver, HomePageUI.CELL_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));

    }

    public void selectDropdownAtRowNumberByColumnName(String columnName, String rowNumber, String valueToSelect) {
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
        waitForElementClickable(driver, HomePageUI.CELL_DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
        selectItemInDefaultDropdown(driver, HomePageUI.CELL_DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect,rowNumber,String.valueOf(columnIndex));
    }

    public void clickToLoadButton() {
        waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_BUTTON);
    }

    public void checkToCheckboxAtRowNumberByColumnName(String columnName, String rowNumber) {
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
        waitForElementClickable(driver, HomePageUI.CELL_CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex) );
        checkToDefaultCheckboxOrRadio(driver, HomePageUI.CELL_CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX,  rowNumber, String.valueOf(columnIndex));
    }

    public void uncheckToCheckboxAtRowNumberByColumnName(String columnName, String rowNumber) {
        int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
        waitForElementClickable(driver, HomePageUI.CELL_CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
        uncheckToDefaultCheckboxOrRadio(driver, HomePageUI.CELL_CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
    }

    public void clickToIconByRowNumber(String rowNumber, String iconName) {
        waitForElementClickable(driver, HomePageUI.CELL_ICON_BY_ROW_INDEX,rowNumber,iconName);
        clickToElement(driver, HomePageUI.CELL_ICON_BY_ROW_INDEX,rowNumber,iconName);

    }
}
