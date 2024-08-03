package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserCustomerInfoUI;

public class UserCustomerInfoPageObject extends BasePage {
    private WebDriver driver;

    public UserCustomerInfoPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isCustomerInfoPageDisplayed() {
        waitForElementVisible(driver, UserCustomerInfoUI.CUSTOMER_INFO_HEADER);
        return isElementDisplayed(driver, UserCustomerInfoUI.CUSTOMER_INFO_HEADER);
    }
}
