package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException {

        String searchFor = "Blue";
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//      WITHOUT PARALLEL EXECUTION
//        StorePage storePage = new HomePage(driver).

//        WITH PARALLEL EXECUTION
        StorePage storePage = new HomePage(getDriver()).
                load().
                navigateToStoreUsingMenu().
                search(searchFor);

//        driver.get("https://askomdch.com");
//
//        HomePage homePage = new HomePage(driver);
//        StorePage storePage = homePage.navigateToStoreUsingMenu();
//
////        Storepage
//        storePage.search("BLUE");
////                enterTextInSearchFld("BLUE").
////                clickSearchBtn();
////        above is structural page object

        /*Billing address way */
/*     BILLING ADDRESS WITH BILLING ADDRESS CLASS GETTER SETTER AND CHECKOUT PAGE FUNCTION
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setFirstName("demo");
        billingAddress.setLastName("user");
        billingAddress.setAddressLineOne("San francisco");
        billingAddress.setCity("San francisco");
        billingAddress.setPostalCode("94188");
        billingAddress.setEmail("askomsch@gmail.com"); */

        /*
         *structural page object
          BillingAddress billingAddress = new BillingAddress();
          billingAddress.setFirstName("demo").
                  setLastName("user").
                  setAddressLineOne("San francisco").
                  setCity("San francisco").
                  setPostalCode("94188").
                  setEmail("askomsch@gmail.com");
        */



        /*BILLING ADDRESS WITH CONSTRUCTOR
        BillingAddress billingAddress= new BillingAddress("demo","user","San francisco","San francisco","94188","askomsch@gmail.com");
*/
/*       BILLING ADDRESS WITH JSON
        BillingAddress billingAddress = new BillingAddress();
        InputStream is = getClass().getClassLoader().getResourceAsStream("myBillingAddress.json");
        billingAddress = JacksonUtils.deserializeJson(is,billingAddress);
*/
//Make it generic
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class);

        Product product= new Product(1215);

        Assert.assertEquals(storePage.getTitle(),"Search results: “"+ searchFor +"”");
//        storePage.clickAddToCartBtn("Blue Shoes");
        storePage.clickAddToCartBtn(product.getName());
//     implicit wait use kar liya hia
//        Thread.sleep(5000);
       CartPage cartPage= storePage.clickViewCart();
//        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckOutPage checkOutPage= cartPage.clickCheckOutBtn();

//

//        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
//        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("BLUE");
//        driver.findElement(By.cssSelector("button[value='Search']")).click();
//        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),"Search results: “BLUE”");
//        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
//
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='View cart']")));
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();

//        Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),"Blue Shoes");
//        driver.findElement(By.cssSelector(".checkout-button")).click();


//        CheckoutPage

//        checkOutPage.
//                enterFirstName("demo").
//                enterLastName("user").
//                enterAddressLineOne("San francisco").
//                enterCity("San francisco").
//                enterPostCode("94188").
//                enterEmail("askomsch@gmail.com").
//                placeOrder();

        checkOutPage.
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();
//        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");

//        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
//        driver.findElement(By.id("billing_last_name")).sendKeys("user");
//        driver.findElement(By.id("billing_address_1")).sendKeys("San francisco");
//        driver.findElement(By.id("billing_city")).sendKeys("San francisco");
//        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//        driver.findElement(By.id("billing_email")).sendKeys("askomsch@gmail.com");
//        driver.findElement(By.id("place_order")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-notice")));
//        Thread.sleep(5000);
//        Assert.assertEquals((driver.findElement(By.cssSelector(".woocommerce-notice")).getText()),"Thank you. Your order has been received.");

    }
    @Test
    public void loginAndCheckOutUsingDirectBankTransfer() throws InterruptedException, IOException {

        String searchFor = "Blue";

//        System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.get("https://askomdch.com");

        //      WITHOUT PARALLEL EXECUTION
//        StorePage storePage = new HomePage(driver).

//        WITH PARALLEL EXECUTION
        StorePage storePage = new HomePage(getDriver()).
                load().
                navigateToStoreUsingMenu().
                search(searchFor);
 /*       HomePage homepage = new HomePage(driver);
        StorePage storepage = homepage.navigateToStoreUsingMenu();
        storepage.search("BLUE");
  */
        Product product = new Product(1215);
        Assert.assertEquals(storePage.getTitle(),"Search results: “"+ searchFor +"”");
//        storePage.clickAddToCartBtn("Blue Shoes");
        storePage.clickAddToCartBtn(product.getName());

//        Thread.sleep(5000);

        CartPage cartPage = storePage.clickViewCart();
//        Assert.assertEquals(cartPage.getProductName(),"Blue Shoes");
        Assert.assertEquals(cartPage.getProductName(),product.getName());

        CheckOutPage checkOutPage = cartPage.clickCheckOutBtn();


//
//        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
//        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("BLUE");
//        driver.findElement(By.cssSelector("button[value='Search']")).click();
//        Assert.assertEquals(driver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),"Search results: “BLUE”");
//        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='View cart']")));
//        Thread.sleep(5000);
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();
//
//        Assert.assertEquals(driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),"Blue Shoes");
//        driver.findElement(By.cssSelector(".checkout-button")).click();
        checkOutPage.clickHereToLoginLink();
//        Thread.sleep(5000);


//        Withou stg_config.properties
//        User user = new User("demo2User","demopwd");

//        With CONFIG.PROPERTIES
        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());

        checkOutPage.login(user.getUsername(),user.getPassword());
//        checkOutPage.login("demo2User","demopwd")
//                .enterFirstName("demo").
//                enterLastName("user").
//                enterAddressLineOne("San francisco").
//                enterCity("San francisco").
//                enterPostCode("94188").
//                enterEmail("askomsch@gmail.com").
//                placeOrder();

        BillingAddress billingAddress= JacksonUtils.deserializeJson("myBillingAddress.json",BillingAddress.class);
        checkOutPage.
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                placeOrder();

//        Thread.sleep(5000);
        Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");



//        //login
//        driver.findElement(By.cssSelector(".showlogin")).click();
//        driver.findElement(By.cssSelector("#username")).sendKeys("demo2User");
//        driver.findElement(By.cssSelector("#password")).sendKeys("demopwd");
//        driver.findElement(By.cssSelector("button[value='Login']")).click();




//        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
//        driver.findElement(By.id("billing_last_name")).sendKeys("user");
//        driver.findElement(By.id("billing_address_1")).sendKeys("San francisco");
//        driver.findElement(By.id("billing_city")).sendKeys("San francisco");
//
//        driver.findElement(By.id("billing_postcode")).clear();
//        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//
////        clear the mail field to write new mail id
//        driver.findElement(By.id("billing_email")).clear();
//        driver.findElement(By.id("billing_email")).sendKeys("askomsch@gmail.com");
//        driver.findElement(By.id("place_order")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-notice")));
//        Thread.sleep(5000);
//        Assert.assertEquals((driver.findElement(By.cssSelector(".woocommerce-notice")).getText()),"Thank you. Your order has been received.");

    }
}
