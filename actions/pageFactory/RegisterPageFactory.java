package pageFactory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePageFactory{
    private WebDriver driver;

    public RegisterPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "register-button")
    private WebElement register_button;

    @FindBy(id = "FirstName-error")
    private WebElement first_name_error_message;

    @FindBy(id = "LastName-error")
    private WebElement last_name_error_message;

    @FindBy(id = "Email-error")
    private WebElement email_error_message;

    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirm_password_error_message;

    @FindBy(id = "FirstName")
    private WebElement first_name_textbox;

    @FindBy(id = "LastName")
    private WebElement last_name_textbox;

    @FindBy(id = "Email")
    private WebElement email_textbox;

    @FindBy(id = "Password")
    private WebElement password_textbox;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirm_password_textbox;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement register_success_message;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logout_link;

    @FindBy(xpath = "//div[contains(@class,'message-error')]//li")
    private WebElement existing_email_error_message;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement validation_password_error_message;

    public void clickToRegisterButton() {
        waitForElementClickable(driver, register_button);
        clickToElement(driver, register_button);
    }

    public String getErrorMessageAtFirstnameTextbox() {
        waitForElementVisible(driver, first_name_error_message);
        return getElementText(driver, first_name_error_message);
    }

    public String getErrorMessageAtLastnameTextbox() {
        waitForElementVisible(driver, last_name_error_message);
        return getElementText(driver, last_name_error_message);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, email_error_message);
        return getElementText(driver, email_error_message);
    }


    public String getErrorMessageAtConfirmPasswordTextbox() {
        waitForElementVisible(driver, confirm_password_error_message);
        return getElementText(driver, confirm_password_error_message);
    }

    public void inputToFirstnameTextbox(String firstName) {
        waitForElementVisible(driver,first_name_textbox);
        sendKeyToElement(driver,first_name_textbox,firstName);
    }

    public void inputToLastnameTextbox(String lastName) {
        waitForElementVisible(driver, last_name_textbox);
        sendKeyToElement(driver, last_name_textbox,lastName);
    }

    public void inputToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver,email_textbox);
        sendKeyToElement(driver,email_textbox,emailAddress);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, password_textbox);
        sendKeyToElement(driver, password_textbox,password);
    }

    public void inputToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver,confirm_password_textbox);
        sendKeyToElement(driver,confirm_password_textbox,confirmPassword);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, register_success_message);
        return getElementText(driver, register_success_message);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver,logout_link);
        clickToElement(driver, logout_link);
    }

    public String getErrorExistingEmailMessage() {
        waitForElementVisible(driver, existing_email_error_message);
        return getElementText(driver, existing_email_error_message);
    }

    public String getValidationErrorMessageAtPasswordTextbox() {
        waitForElementVisible(driver, validation_password_error_message);
        return getElementText(driver, validation_password_error_message);
    }
}
