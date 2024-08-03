package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.constants.DriverType;

import java.time.Duration;

public class DriverManager {

//    public WebDriver initializeDriver(){

//    testng
public WebDriver initializeDriver(String browser){


//
//        WebDriverManager.chromedriver().setup();

//        With Cache path so driver will download here and with new version
//        WebDriverManager.chromedriver().cachePath("Drivers").setup();
//        WebDriver driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().cachePath("Driver").setup();
//        WebDriver driver = new FirefoxDriver();
//
//
//
//        WebDriver driver;
//        String browser = System.getProperty("browser");
//        driver = switch (browser.toLowerCase()) {
//            case "chrome" -> {
//                WebDriverManager.chromedriver().cachePath("Drivers").setup();
//                driver =  new ChromeDriver();
//            }
//            case "firefox" -> {
//                WebDriverManager.firefoxdriver().cachePath("Driver").setup();
//                driver =  new FirefoxDriver();
//            }
//            default -> throw new IllegalStateException("Invalid Browser Name:" + browser);
//        };


//        USING ENUM
        WebDriver driver;
//    String localBrowser;



//        run with mvn
//         localBrowser = System.getProperty("browser");

//        Run on ide
//         localBrowser = System.getProperty("browser","CHROME");

//        using testng
//        localBrowser=browser;

//    run with maven and testng if it is from maven it takes "browser" if it is run with testng it takes browser
//    browser = System.getProperty("browser",browser);
//    WE CHANGE THE ABOVE LINE AT THE TIME OF PARALLEL RUN AN PUT THIS LINE IN BASE TEST

//        switch (DriverType.valueOf(localBrowser)) {
    switch (DriverType.valueOf(browser)) {
            case CHROME -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                 driver = new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().cachePath("Driver").setup();
                 driver =new FirefoxDriver();
            }
            default -> throw new IllegalStateException("Invalid Browser Name:" + browser);
        };

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
