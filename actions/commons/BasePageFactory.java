package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePageFactory {
    public static BasePage getBasePageObject() {
        return new BasePage();
    }

    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public void sendKeyToElement(WebDriver driver, WebElement element, String textValue) {
        element.clear();
        element.sendKeys(textValue);
    }
    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getElementText(WebDriver driver, WebElement element) {
        return element.getText();
    }

    public boolean isElementDisplayed(WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }

    public void waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    private long longTimeout = 30;
}
