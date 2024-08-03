package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

//    protected WebDriver driver;

//    for parallel run with thread
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

//    @BeforeMethod
//    public void startDriver(){
//        driver = new DriverManager().initializeDriver();
//
//    }

//    TESTNG
    @Parameters("browser")
    @BeforeMethod
    public void startDriver(@Optional String browser){
//      without parallel
//        driver = new DriverManager().initializeDriver(browser);


//        THE BELOW LINE PUT HERE AT THE TIME OF PARALLEL EXECUTION
//        browser = System.getProperty("browser",browser);

//        get browser with config properties
        if(browser==null) {
            browser = "CHROME";
        }
//        WITH PARALLEL EXECUTION
        setDriver( new DriverManager().initializeDriver(browser));

        System.out.println("CURENT THREAD: " + Thread.currentThread().getId() +","+ "Driver"+ getDriver());
    }

    @AfterMethod
    public void quitDriver(){
//        driver.quit();

        System.out.println("CURENT THREAD: " + Thread.currentThread().getId() +","+ "Driver"+ getDriver());

//        FOR PARALLEL EXECUTION
        getDriver().quit();
    }

}
