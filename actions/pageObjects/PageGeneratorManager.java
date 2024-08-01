package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
        return new CustomerInfoPageObject(driver);
    }
    public static AddressesPageObject getAddressesPage(WebDriver driver) {
        return new AddressesPageObject(driver);
    }
    public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
        return new MyProductReviewPageObject(driver);
    }
    public static RewardPointsPageObject getRewardPointsPage(WebDriver driver) {
        return new RewardPointsPageObject(driver);
    }
    public static SearchPageObject getSearchPage(WebDriver driver){
        return new SearchPageObject(driver);
    }
    public static ShippingAndReturnPageObject getShippingAndReturnPage(WebDriver driver){
        return new ShippingAndReturnPageObject(driver);
    }
    public static SiteMapPageObject getSiteMapPage(WebDriver driver){
        return new SiteMapPageObject(driver);
    }
    public static WishListHeaderPageObject getWishLishHeaderPage(WebDriver driver){
        return new WishListHeaderPageObject(driver);
    }
}
