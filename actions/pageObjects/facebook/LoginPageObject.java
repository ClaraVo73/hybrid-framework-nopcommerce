package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject (WebDriver driver){
        this.driver = driver;
    }

    public void clickToCreateNewAccountButton() {
        waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
    }

    public boolean isEmailAddressTextboxDisplayed() {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXBOX);
        return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXBOX);
    }

    public boolean isEmailAddressConfirmTextboxDisplayed() {
        return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_CONFIRM_TEXTBOX);
    }

    public void clickCloseIconAtRegisterForm() {
        waitForElementClickable(driver,LoginPageUI.CLOSE_ICON_AT_REGISTER_FORM);
        clickToElement(driver, LoginPageUI.CLOSE_ICON_AT_REGISTER_FORM);
    }

    public boolean isConfirmEmailTexboxUndisplayed() {
        return isELementUndisplayed(driver, LoginPageUI.EMAIL_ADDRESS_CONFIRM_TEXTBOX);
    }
}
