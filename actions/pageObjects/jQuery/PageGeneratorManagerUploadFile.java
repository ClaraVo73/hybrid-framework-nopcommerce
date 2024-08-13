package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerUploadFile {
    public static HomePageUploadFileObject getHomePage(WebDriver driver){
        return new HomePageUploadFileObject(driver);
    }
}
