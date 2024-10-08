package pageUIs.jQuery;

public class HomePageTableUI {
    public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//ul[@class='qgrd-pagination-ul']//a[text()='%s']";
    public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static final String SEARCH_HEADER_TEXTBOX = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
    public static final String TOTAL_PAGINATION ="xpath=//ul[@class='qgrd-pagination-ul']//li[@class='qgrd-pagination-page']";
    public static final String PAGINATION_PAGE_BY_INDEX ="xpath=//ul[@class='qgrd-pagination-ul']//li[@class='qgrd-pagination-page'][%s]/a";
    public static final String ALL_ROW_EACH_PAGE ="xpath=//tbody//tr";
    public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
    public static final String CELL_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
    public static final String CELL_DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";
    public static final String CELL_CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";
    public static final String CELL_ICON_BY_ROW_INDEX =  "xpath=//tbody/tr[%s]//button[@title='%s']";
    public static final String LOAD_BUTTON = "css=button#load";


}
