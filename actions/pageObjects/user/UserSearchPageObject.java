package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserSearchPageObject extends BasePage {
    private WebDriver driver;

    public UserSearchPageObject(WebDriver driver){
        this.driver = driver;
    }

}
