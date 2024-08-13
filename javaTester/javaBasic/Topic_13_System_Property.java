package javaBasic;

import java.io.File;

public class Topic_13_System_Property {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles"+ File.separator;
    public static void main(String[] args){
        System.out.println("Upload file link: "+ UPLOAD_FILE);
    }

}
