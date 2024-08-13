package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerTable {
    public static HomePageTableObject getHomePage(WebDriver driver){
        return new HomePageTableObject(driver);
    }
}
