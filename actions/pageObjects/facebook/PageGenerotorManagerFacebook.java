package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGenerotorManagerFacebook {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

}
