package pageUIs.jQuery;

public class HomePageUI {
    public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//ul[@class='qgrd-pagination-ul']//a[text()='%s']";
    public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static final String SEARCH_HEADER_TEXTBOX = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String TOTAL_PAGINATION ="xpath=//ul[@class='qgrd-pagination-ul']//li[@class='qgrd-pagination-page']";
    public static final String PAGINATION_PAGE_BY_INDEX ="xpath=//ul[@class='qgrd-pagination-ul']//li[@class='qgrd-pagination-page'][%s]/a";
    public static final String ALL_ROW_EACH_PAGE ="xpath=//tbody//tr";

}
