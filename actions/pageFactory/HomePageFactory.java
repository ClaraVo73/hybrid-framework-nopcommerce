package pageFactory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePageFactory {
    private WebDriver driver;

    public HomePageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how=How.XPATH, using = "//a[@class='ico-register']")
    private WebElement register_link;

    @FindBy(xpath= "//a[@class='ico-login']")
    private WebElement login_link;

    @FindBy(xpath= "//a[@class='ico-account']")
    private WebElement my_account_link;


    public void clickToRegisterLink(){
        waitForElementClickable(driver, register_link);
        clickToElement(driver, register_link);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, login_link);
        clickToElement(driver, login_link);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementVisible(driver, my_account_link);
        return isElementDisplayed(driver, my_account_link);
    }
}
