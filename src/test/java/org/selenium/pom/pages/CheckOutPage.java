package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

public class CheckOutPage extends BasePage {


    private final By firstNameFld = By.id("billing_first_name");
    private final By lastNamefld = By.id("billing_last_name");
    private final By addressLineOneFld = By.id("billing_address_1");
    private final By billingCityFld= By.id("billing_city");
    private final By billingPostCodeFld = By.id("billing_postcode");
    private final By billingEmailFld = By.id("billing_email");
    private final By placeOrderBtn= By.id("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");

    private final By clickHereToLoginLink = By.cssSelector(".showlogin");
    private final By userNamefld = By.cssSelector("#username");
    private final By passwordfld =By.cssSelector("#password");
    private final By loginBtn = By.cssSelector("button[value='Login']");

    private final By overlay = By.cssSelector(".blockUI.block lOverlay");
    private final By countryDropDown = By.id("billing_country");
    private final By stateDropDown = By.id("billing_state");

    private final By directBankTransferRasdioBtn = By.id("payment_method_bacs");

   private final By alternateCountryDropDown = By.id("select2-billing_country-container");
   private  final By alternateeStateDropDown = By.id("select2-billing_state-container");

    public CheckOutPage(WebDriver driver) {

        super(driver);
    }
    public CheckOutPage enterFirstName (String firstName){
//     We use below method without explicit wait  like this
//        driver.findElement(firstNameFld).clear();
//        driver.findElement(firstNameFld).sendKeys(firstName);

//        with explicit wait
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFld));
        e.clear();
        e.sendKeys(firstName);
        return this;
    }
    public CheckOutPage enterLastName (String lastName){


//      Before Explicit wait
//        driver.findElement(lastNamefld).clear();
//        driver.findElement(lastNamefld).sendKeys(lastName);

//        After EXPLIcIT WAIT
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNamefld));
        e.clear();
        e.sendKeys(lastName);
        return this;
    }

    public CheckOutPage selectCountry(String countryName){

//        Select select = new Select(driver.findElement(countryDropDown));
////        wait.until(ExpectedConditions.elementToBeClickable(countryDropDown));
//        select.selectByVisibleText(countryName);
//        return this;

        wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+countryName+"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        return this;

    }

    public CheckOutPage selectState(String stateName){
//        Select select = new Select(driver.findElement(stateDropDown));
//        select.selectByVisibleText(stateName);
//        return this;

        wait.until(ExpectedConditions.elementToBeClickable(alternateeStateDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+ stateName+"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        return this;
    }
    public CheckOutPage enterAddressLineOne (String addressLineOne){
//        BEFORE EXPLICIT WAIT
//        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);

//        AFTER EXPLICIT WAIT
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(addressLineOneFld));
        e.sendKeys(addressLineOne);
        return this;
    }
    public CheckOutPage enterCity (String city){
//        BEFORE EXPLICIT WAIT
//       driver.findElement(billingCityFld).sendKeys(city);

//      After EXPLICIT WAIT
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld));

        e.clear();
        e.sendKeys(city);
        return this;

    }
    public CheckOutPage enterPostCode (String postCode){
        //        BEFORE EXPLICIT WAIT
//      driver.findElement(billingPostCodeFld).sendKeys(postCode);
//        After EXPLICIT WAIT
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostCodeFld));

        e.clear();e.sendKeys(postCode);
        return this;
    }
    public CheckOutPage enterEmail (String email){
        //        BEFORE EXPLICIT WAIT
//        driver.findElement(billingEmailFld).clear();
//        driver.findElement(billingEmailFld).sendKeys(email);

        //        After EXPLICIT WAIT
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld));
        e.clear();
        e.sendKeys(email);
        return this;
    }
    public CheckOutPage placeOrder(){

        waitForOverlaysDisappear(overlay);
        driver.findElement(placeOrderBtn).click();
        return this;
    }
    public String getNotice(){
        //        BEFORE EXPLICIT WAIT
//        return driver.findElement(successNotice).getText();
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice));
       return e.getText();
    }


    public CheckOutPage setBillingAddress(BillingAddress billingAddress){
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                selectCountry(billingAddress.getCountry()).
                enterAddressLineOne(billingAddress.getAddressLineOne()).
                enterCity(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                enterPostCode(billingAddress.getPostalCode()).
                enterEmail(billingAddress.getEmail());
    }



    public CheckOutPage clickHereToLoginLink(){

        //        BEFORE EXPLICIT WAIT
// driver.findElement(clickHereToLoginLink).click();
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(clickHereToLoginLink));
        e.click();
        return this;
    }

    public CheckOutPage enterUserName(String username){
//        driver.findElement(userNamefld).sendKeys(username);
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(userNamefld));
        e.sendKeys(username);
        return this;
    }

    public CheckOutPage enterPassword(String password){
//        driver.findElement(passwordfld).sendKeys(password);
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordfld));
        e.sendKeys(password);
        return this;
    }
    public CheckOutPage clickLoginBtn(){
//        driver.findElement(loginBtn).click();
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
        e.click();
        return this;
    }
    public CheckOutPage login(String username, String password){
        return enterUserName(username).enterPassword(password).clickLoginBtn();
    }


    public CheckOutPage selectDirectBankTransfer(){
       WebElement e= wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRasdioBtn));
       if(!e.isSelected()){
           e.click();
       }
       return this;
    }

}
