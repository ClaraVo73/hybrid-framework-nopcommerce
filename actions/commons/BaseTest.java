package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName) {
        if (browserName.equals("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else if (browserName.equals("chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browserName.equals("edge")) {
            driver = WebDriverManager.edgedriver().create();
        } else if (browserName.equals("opera")) {
            driver = WebDriverManager.operadriver().create();
        } else {
            throw new RuntimeException("Please enter the correct Browser name.");
        }
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().maximize();
        driver.get(GlobalConstants.PORTAL_PRODUCTION_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String environmentName) {
        if (browserName.equals("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else if (browserName.equals("chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browserName.equals("edge")) {
            driver = WebDriverManager.edgedriver().create();
        } else if (browserName.equals("opera")) {
            driver = WebDriverManager.operadriver().create();
        } else {
            throw new RuntimeException("Please enter the correct Browser name.");
        }
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().maximize();
        driver.get(getEnvironmentUrl(environmentName));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private String getEnvironmentUrl(String environmentName) {
        String url = null;
        switch (environmentName) {
            case "Staging":
                url = GlobalConstants.PORTAL_STAGING_URL;
                break;
            case "Production":
                url = GlobalConstants.PORTAL_STAGING_URL;
                break;
        }
        return url;
    }
}
