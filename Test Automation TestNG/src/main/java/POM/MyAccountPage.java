package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {
    @FindBy(id = "reg_email")
    public static WebElement mailInput;

    @FindBy(id = "reg_password")
    public static WebElement passwordInput;

    @FindBy(xpath = "//input[@name='register']")
    public static WebElement registerButton;

    @FindBy(xpath = "//p[contains(text(), 'From your account dashboard you can view your')]")
    public static WebElement loggedInMessage;
}
