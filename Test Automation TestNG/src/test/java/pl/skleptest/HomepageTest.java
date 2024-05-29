package pl.skleptest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomepageTest {
    private WebDriver driver;
    String homepageUrl = "https://skleptest.pl/";
    String homepageTitle = "Generic Shop – Just another web shop";
    @BeforeTest
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(testName = "Homepage Test", groups = { "groups" })
    void openHomepage(){
        driver.get(homepageUrl);
        Assert.assertEquals(homepageTitle, driver.getTitle());
    }
    @AfterTest
    void quit(){
        driver.quit();
    }
}
