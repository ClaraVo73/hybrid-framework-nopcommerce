package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePage {

    public static BasePage getBasePageObject() {
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String textValue) {
        waitForAlertPresence(driver).sendKeys(textValue);
    }

    public void switchToWindowByID(WebDriver driver, String windowID) {
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            if (!id.equals(windowID)) {
                driver.switchTo().window(id);
                break;
            }

        }
    }

    public void switchToWindowByTitle(WebDriver driver, String tabTitle) {
        Set<String> allWindowIDs = driver.getWindowHandles();

        for (String id : allWindowIDs) {
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(tabTitle)) {
                break;
            }

        }
    }

    public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }

    }

    private By getByXpath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    private WebElement getWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElement(getByXpath(xpathLocator));
    }

    private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElements(getByXpath(xpathLocator));
    }

    public void clickToElement(WebDriver driver, String xpathLocator) {
        getWebElement(driver, xpathLocator).click();
    }

    public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
        Select select = new Select(getWebElement(driver, xpathLocator));
        select.selectByValue(textItem);
    }

    public String getSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
        Select select = new Select(getWebElement(driver, xpathLocator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
        Select select = new Select(getWebElement(driver, xpathLocator));
        return select.isMultiple();
    }

    public void selectItemInDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
        getWebElement(driver, parentXpath).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedTextItem)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                break;
            }
        }
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
        return getWebElement(driver, xpathLocator).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).getText();
    }

    public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
        return getWebElement(driver, xpathLocator).getCssValue(propertyName);
    }

    public String getHexColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementSize(WebDriver driver, String xpathLocator) {
        return getListWebElement(driver, xpathLocator).size();
    }

    public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isDisplayed();
    }

    public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isSelected();
    }

    public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
        driver.switchTo().frame(getWebElement(driver, xpathLocator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, xpathLocator)).perform();
    }

    public void highLightElement(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathLocator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String xpathLocator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, xpathLocator));
    }

    public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
    }

    public void sendKeyToElementByJS(WebDriver driver, String xpathLocator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, xpathLocator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String xpathLocator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, xpathLocator));
    }

    public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
    }

    public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getWebElement(driver, xpathLocator));
    }

    public void waitForElementVisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
    }

    public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
    }

    public void waitForElementClickable(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
    }

    public void waitForElementSelected(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeSelected(getByXpath(xpathLocator)));
    }

    private long longTimeout = 30;
}
