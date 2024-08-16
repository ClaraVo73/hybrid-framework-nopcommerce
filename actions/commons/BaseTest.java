package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected final Logger log;

    protected BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    public WebDriver getBrowserDriver(String browserName) {
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
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }

//    protected WebDriver getBrowserDriver(String browserName, String environmentName) {
//        if (browserName.equals("firefox")) {
//            driver = WebDriverManager.firefoxdriver().create();
//        } else if (browserName.equals("chrome")) {
//            driver = WebDriverManager.chromedriver().create();
//        } else if (browserName.equals("edge")) {
//            driver = WebDriverManager.edgedriver().create();
//        } else if (browserName.equals("opera")) {
//            driver = WebDriverManager.operadriver().create();
//        } else {
//            throw new RuntimeException("Please enter the correct Browser name.");
//        }
//        driver.manage().window().setPosition(new Point(0, 0));
//        driver.manage().window().maximize();
//        driver.get(getEnvironmentUrl(environmentName));
//        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
//        return driver;
//    }

    public WebDriver getBrowserDriver(String browserName, String appUrl) {
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
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }

    protected String getEnvironmentUrl(String environmentName) {
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

    protected boolean verifyTrue(boolean condition) {
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            log.info("---------------------- Passed -----------------------");
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------- Failed -----------------------");
        }
        return status;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean status = true;
        try {
            Assert.assertFalse(condition);
            log.info("---------------------- Passed -----------------------");
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------- Failed -----------------------");
        }
        return status;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean status = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("---------------------- Passed -----------------------");
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
            log.info("---------------------- Failed -----------------------");
        }
        return status;

    }
}
