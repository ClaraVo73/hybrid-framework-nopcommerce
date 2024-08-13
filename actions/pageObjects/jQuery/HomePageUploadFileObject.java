package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomePageUploadFilesUI;

import java.util.List;

public class HomePageUploadFileObject extends BasePage {
    WebDriver driver;

    public HomePageUploadFileObject(WebDriver driver) {
        this.driver = driver;

    }


    public boolean isFileLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUploadFilesUI.FILE_NAME_LOADED, fileName);
        return isElementDisplayed(driver, HomePageUploadFilesUI.FILE_NAME_LOADED, fileName);
    }

    public boolean isFileUpLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUploadFilesUI.FILE_NAME_UPLOADED_LINK, fileName);
        return isElementDisplayed(driver, HomePageUploadFilesUI.FILE_NAME_UPLOADED_LINK, fileName);
    }
    public boolean isFileImageUpLoadedByName(String fileName) {
        waitForElementVisible(driver, HomePageUploadFilesUI.FILE_NAME_UPLOADED_IMAGE, fileName);
        return isImageLoaded(driver, HomePageUploadFilesUI.FILE_NAME_UPLOADED_IMAGE, fileName);
    }



    public void clickToStartButton() {
        List<WebElement> startButtons = getListWebElement(driver, HomePageUploadFilesUI.START_BUTTON);
        for(WebElement startButton : startButtons){
            startButton.click();
            sleepInSecond(2);
        }
    }
}
