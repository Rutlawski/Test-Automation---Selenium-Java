package pl.skleptest;

import POM.Homepage;
import POM.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchInputTest {
    private WebDriver driver;
    String homepageUrl = "https://skleptest.pl/";
    @BeforeTest
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, Homepage.class);
        PageFactory.initElements(driver, SearchPage.class);
    }
    @Parameters( { "product" } )
    @Test(testName = "Search Input Test", groups = { "parameters" })
    void searchDress(String i) throws InterruptedException {
        driver.get(homepageUrl);
        Homepage.searchInput.sendKeys(i);
        Homepage.searchButton.click();
        Assert.assertTrue(SearchPage.productCard.isDisplayed());
    }
    @AfterTest
    void quit(){
        driver.quit();
    }
}
