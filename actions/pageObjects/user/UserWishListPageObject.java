package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class UserWishListPageObject extends BasePage {
    private WebDriver driver;

    public UserWishListPageObject(WebDriver driver){
        this.driver = driver;
    }

}
