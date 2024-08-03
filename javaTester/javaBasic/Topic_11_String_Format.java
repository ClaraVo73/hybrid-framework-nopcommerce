package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_String_Format {
    public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";

    public static void main(String[] args) {
        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper","Sitemap");
        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper","Shipping & returns");
        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper","Privacy notice");
        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper","Conditions of Use");
        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper","About us");
        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper","Search");
        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper","My account");
        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "header-upper","Register");
        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME, "header-menu","Computers ");
    }
//    public static void clickToLink(String dynamicLocator, String pageName){
//        String locator = String.format(dynamicLocator,pageName);
//        System.out.println("Click to:" +locator);
//
//    }
    public static void clickToLink(String dynamicLocator, String... params){
        String locator = String.format(dynamicLocator, (Object[]) params);
        System.out.println("Click to link:" +locator);

    }

}
