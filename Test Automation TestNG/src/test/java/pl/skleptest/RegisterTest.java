package pl.skleptest;

import POM.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.skleptest.DataProvider.MyAccountPageDataProvider;
import pl.skleptest.DataProvider.MyAccountPageObject;

public class RegisterTest {
    private WebDriver driver;
    String registerPageUrl = "https://skleptest.pl/my-account/";
    String expectedLoggedInMessage = "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.";
    @BeforeTest
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, MyAccountPage.class);
    }
    @Test(dataProvider = "DataProviderMyAccountObject", dataProviderClass = MyAccountPageDataProvider.class)
    void register(MyAccountPageObject myAccountPageObject) throws InterruptedException {
        driver.get(registerPageUrl);
        MyAccountPage.mailInput.sendKeys(myAccountPageObject.getMail());
        MyAccountPage.passwordInput.sendKeys(myAccountPageObject.getPassword());
        Thread.sleep(2000);
        MyAccountPage.registerButton.click();
        MyAccountPage.registerButton.click();
        Assert.assertEquals(expectedLoggedInMessage, MyAccountPage.loggedInMessage.getText());
    }
    @AfterTest
    void quit(){
        driver.quit();
    }
}
