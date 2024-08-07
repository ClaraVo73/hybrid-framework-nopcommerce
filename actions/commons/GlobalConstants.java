package commons;

import java.io.File;

public class GlobalConstants {
    public static final String PORTAL_PRODUCTION_URL = "https://demo.nopcommerce.com/";
    public static final String ADMIN_PRODUCTION_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
    public static final String PORTAL_STAGING_URL = "https://demo.nopcommerce.com/";
    public static final String ADMIN_STAGING_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");

    public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
    public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
    public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";

    public static final String DB_DEV_URL = "192.168.1.185:9860";
    public static final String DB_DEV_USER = "mjdisuids";
    public static final String DB_DEV_PASSWORD = "45675";

    public static final String DB_TEST_URL = "192.168.1.185:9890";
    public static final String DB_TEST_USER = "FHSDUFYDU";
    public static final String DB_TEST_PASSWORD = "67823";

    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final long RETRY_TEST_FAIL = 3;



}
