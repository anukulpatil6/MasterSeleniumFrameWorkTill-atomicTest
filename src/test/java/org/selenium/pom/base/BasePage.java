package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.utils.ConfigLoader;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    }
//    WITHOUT USE OF SINGLETON (CONFIG PROPERTIES)
//    public void load(String endPoint){
//        driver.get("https://askomdch.com"+endPoint);
//    }


//    WITH SINGLETON (CONFIG.PROPERTIES)
    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() +endPoint);
    }


//   IMPLICIT WAIT
//    public void waitForOverlaysDisappear(By overlay){
//        List<WebElement> overlays = driver.findElements(overlay);
//        System.out.println("OVERLAYS SIZE" + overlays.size());
//        if(overlays.size()>0){
//            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(overlays));
//        }
//        else System.out.println("overlay not found");
//    }

    //EXPLICIT WAIT
    public void waitForOverlaysDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAYS SIZE" + overlays.size());
        if(overlays.size()>0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
        }
        else System.out.println("overlay not found");
    }
}
