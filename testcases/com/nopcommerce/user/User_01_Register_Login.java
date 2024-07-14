package com.nopcommerce.user;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class User_01_Register_Login {
    //Toan cuc: su dung trong class
    String homePageUrl = "";
    @BeforeClass
    public void beforeClass(){

    }

    @Test
    public void TC_01(){
        // Cuc bo: su dung trong pham vi cua testcase/ham
        String homePageUrl ="";

        System.out.println(homePageUrl);
        //Block code
        if (3<5){
            //Cuc bo
            String homePageTitle ="";

            System.out.println(homePageTitle);
        }

    }

    @Test
    public void TC_02(){
        System.out.println(homePageUrl);

    }

    @Test
    public void TC_03(){

    }

    @Test
    public void TC_04(){

    }



    @AfterClass
    public void afterClass(){

    }
}
