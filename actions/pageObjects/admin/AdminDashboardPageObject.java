package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminDashboardPageUI;


public class AdminDashboardPageObject extends BasePage {
    private WebDriver driver;

    public AdminDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isDashboardHeaderDisplayed(){
        waitForElementVisible(driver,AdminDashboardPageUI.DASHBOARD_HEADER);
        return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
    }

}
