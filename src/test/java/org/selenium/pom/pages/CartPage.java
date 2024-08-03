package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

//     private final By productName = By.cssSelector("td[class='product-name'] a");
//     private final By checkOutBtn = By.cssSelector(".checkout-button");
//    private final By cartHeading = By.cssSelector(".has-text-align-center");

    @FindBy(css = "td[class='product-name'] a") private WebElement productName;
    @FindBy(css = ".checkout-button") @CacheLookup private WebElement checkOutBtn;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

//    public Boolean isLoaded(){
//       return wait.until(ExpectedConditions.textToBe(cartHeading,"Cart"));
//    }
    public String getProductName(){
      return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
//    return driver.findElement(productName).getText();
    }

    public CheckOutPage clickCheckOutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
//        driver.findElement(checkOutBtn).click();
        return new CheckOutPage(driver);
    }
}

