package pageFactory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePageFactory {
    private WebDriver driver;

    public LoginPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath= "//button[@class='button-1 login-button']")
    private WebElement login_button;

    @FindBy(xpath= "//span[@id='Email-error']")
    private WebElement email_error_message;

    @FindBy(xpath= "//input[@class='email']")
    private WebElement email_textbox;

    @FindBy(xpath= "//input[@class='password']")
    private WebElement password_textbox;

    @FindBy(xpath= "//div[@class='message-error validation-summary-errors']")
    private WebElement email_error_unsuccessful_message;

    public void clickToLoginButton() {
        waitForElementClickable(driver, login_button);
        clickToElement(driver, login_button);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, email_error_message);
        return getElementText(driver, email_error_message);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, email_textbox);
        sendKeyToElement(driver,email_textbox,email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, password_textbox);
        sendKeyToElement(driver, password_textbox,password);
    }

    public String getErrorUnsuccessfullyMessage() {
        waitForElementVisible(driver, email_error_unsuccessful_message);
        return getElementText(driver, email_error_unsuccessful_message);
    }

}
