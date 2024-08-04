package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserChangePasswordPageObject extends BasePage {
    private WebDriver driver;

    public UserChangePasswordPageObject(WebDriver driver){
        this.driver = driver;
    }

}
