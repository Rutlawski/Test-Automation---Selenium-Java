import org.example.POM.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.UUID;

public class TestShopAutomation {
    private WebDriver driver;
    String homepageUrl = "https://skleptest.pl/";
    String registerPageUrl = "https://skleptest.pl/my-account/";
    String homepageTitle = "Generic Shop – Just another web shop";
    String expectedSearchErrorMessage = "NOTHING FOUND";
    String expectedCartHeaderProductText = "My Cart - zł 20.00";
    String expectedEmptyCartMessage = "Your cart is currently empty.";
    String expectedLoggedInMessage = "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.";
    String expectedEmptyLoggedMessage = "Billing First name is a required field.\n" +
            "Billing Last name is a required field.\n" +
            "Billing Street address is a required field.\n" +
            "Billing Town / City is a required field.\n" +
            "Billing Phone is a required field.\n" +
            "Billing Email address is a required field.\n" +
            "Please enter a valid postcode / ZIP.";
    String expectedIncorrectLoggedMessage = "Please enter a valid postcode / ZIP.\n" +
            "Billing Email address is not a valid email address.";
    String uuid = UUID.randomUUID().toString();

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, Homepage.class);
        PageFactory.initElements(driver, SearchResultsPage.class);
        PageFactory.initElements(driver, CartPage.class);
        PageFactory.initElements(driver, MyAccountPage.class);
        PageFactory.initElements(driver, CheckoutPage.class);
    }
    @Test //Opens Homepage and verifies title
    void openHomepage(){
        driver.get(homepageUrl);
        Assertions.assertEquals(homepageTitle, driver.getTitle());
    }
    @Test //Searches a product in Search Input and verifies
    void searchProduct(){
        driver.get(homepageUrl);
        Homepage.searchInput.sendKeys("Dress");
        Homepage.searchButton.click();
        Assertions.assertTrue(SearchResultsPage.firstProductCard.isDisplayed());
    }
    @Test //Searches an incorrect product and verifies error message
    void searchIncorrectProduct(){
        driver.get(homepageUrl);
        Homepage.searchInput.sendKeys("clothes");
        Homepage.searchButton.click();
        Assertions.assertEquals(expectedSearchErrorMessage, SearchResultsPage.searchErrorMessage.getText());
    }
    @Test //adds a product to cart and verifies
    void addProduct() throws InterruptedException {
        driver.get(homepageUrl);
        Homepage.addToCartButton.click();
        Thread.sleep(1000);
        Homepage.cartHeader.click();
        Assertions.assertEquals(Homepage.cartHeader.getText(), expectedCartHeaderProductText);
    }
    @Test //removes a product from cart and verifies
    void removeProduct() throws InterruptedException {
        driver.get(homepageUrl);
        Homepage.addToCartButton.click();
        Thread.sleep(1000);
        Homepage.cartHeader.click();
        CartPage.minusButton.click();
        CartPage.updateCartButton.click();
        Thread.sleep(1000);
        Assertions.assertEquals(expectedEmptyCartMessage, CartPage.emptyCartMessage.getText());
    }
    @Test //adds product, changes it's quantity and verifies
    void changeQuantity() throws InterruptedException {
        driver.get(homepageUrl);
        Homepage.addToCartButton.click();
        Thread.sleep(1000);
        Homepage.cartHeader.click();
        String cartHeaderBefore = Homepage.cartHeader.getText();
        CartPage.plusButton.click();
        CartPage.updateCartButton.click();
        Homepage.cartHeader.click();
        String cartHeaderAfter = Homepage.cartHeader.getText();
        Assertions.assertNotEquals(cartHeaderAfter, cartHeaderBefore);
    }
    @Test //registers the user and verifies logged in message
    void register(){
        driver.get(registerPageUrl);
        MyAccountPage.mailInput.sendKeys(uuid + "@gmail.com");
        MyAccountPage.passwordInput.sendKeys(uuid);
        MyAccountPage.registerButton.click();
        Assertions.assertEquals(expectedLoggedInMessage, MyAccountPage.loggedInMessage.getText());
    }
    @Test //leaves payment data empty and verifies error message
    void fillEmptyPaymentData() throws InterruptedException {
        driver.get(homepageUrl);
        Homepage.addToCartButton.click();
        Thread.sleep(1000);
        Homepage.cartHeader.click();
        Thread.sleep(1000);
        CartPage.checkoutButton.click();
        Thread.sleep(1000);
        CheckoutPage.placeOrderButton.click();
        Thread.sleep(1000);
        Assertions.assertEquals(expectedEmptyLoggedMessage, CheckoutPage.errorMessage.getText());
    }
    @Test //fills incorrect payment data and verifies error message
    void fillIncorrectPaymentData() throws InterruptedException {
        driver.get(homepageUrl);
        Homepage.addToCartButton.click();
        Thread.sleep(1000);
        Homepage.cartHeader.click();
        Thread.sleep(1000);
        CartPage.checkoutButton.click();
        Thread.sleep(1000);
        CheckoutPage.firstNameInput.sendKeys("1111");
        CheckoutPage.lastNameInput.sendKeys("1111");
        CheckoutPage.adressInput.sendKeys("1111");
        CheckoutPage.cityInput.sendKeys("1111");
        CheckoutPage.postCodeInput.sendKeys("1111");
        CheckoutPage.phoneInput.sendKeys("1111");
        CheckoutPage.mailInput.sendKeys("1111");
        Thread.sleep(1000);
        CheckoutPage.placeOrderButton.click();
        Thread.sleep(1000);
        Assertions.assertEquals(expectedIncorrectLoggedMessage, CheckoutPage.errorMessage.getText());
    }
    @Test //E2E Test - A full user journey
    void e2eTest() throws InterruptedException {
        driver.get(homepageUrl);
        Homepage.myAccountButton.click();
        MyAccountPage.mailInput.sendKeys(uuid + "@gmail.com");
        MyAccountPage.passwordInput.sendKeys(uuid);
        MyAccountPage.registerButton.click();
        Thread.sleep(1000);
        Homepage.genericShopButton.click();
        Homepage.addToCartButton.click();
        Thread.sleep(1000);
        Homepage.cartHeader.click();
        CartPage.plusButton.click();
        CartPage.checkoutButton.click();
        CheckoutPage.firstNameInput.sendKeys("Marek");
        CheckoutPage.lastNameInput.sendKeys("Ostrowski");
        CheckoutPage.adressInput.sendKeys("Testerska");
        CheckoutPage.cityInput.sendKeys("ZG");
        CheckoutPage.phoneInput.sendKeys("(+48)222222222");
        CheckoutPage.postCodeInput.sendKeys("22222");
        CheckoutPage.radioButton.click();
        Thread.sleep(1000);
        CheckoutPage.placeOrderButton.click();
        Assertions.assertTrue(CheckoutPage.headerMessage.isDisplayed());
    }
    @AfterEach
    void quit(){
        driver.quit();
    }
}
