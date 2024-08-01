package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SearchPageObject extends BasePage {
    private WebDriver driver;

    public SearchPageObject(WebDriver driver){
        this.driver = driver;
    }

}
