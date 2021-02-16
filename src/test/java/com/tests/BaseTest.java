package com.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;



public class BaseTest {

    protected WebDriver driver;





    @Parameters({"browser"})

    @BeforeTest
    public void setupDriver(String browser) throws MalformedURLException {

        String host = "localhost";
        DesiredCapabilities dc;
        System.out.println(browser);

        if (browser.equals("firefox")) {
            dc = DesiredCapabilities.firefox();

        } else {
            dc = DesiredCapabilities.chrome();
        }


        String completeUrl = "http://" + host + ":4444/wd/hub";

        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);

    }



    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }



}