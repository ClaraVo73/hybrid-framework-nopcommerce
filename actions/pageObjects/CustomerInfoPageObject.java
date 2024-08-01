package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoUI;

public class CustomerInfoPageObject extends BasePage {
    private WebDriver driver;

    public CustomerInfoPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isCustomerInfoPageDisplayed() {
        waitForElementVisible(driver, CustomerInfoUI.CUSTOMER_INFO_HEADER);
        return isElementDisplayed(driver, CustomerInfoUI.CUSTOMER_INFO_HEADER);
    }
}
