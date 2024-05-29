package org.example.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
    @FindBy(id = "billing_first_name")
    public static WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    public static WebElement lastNameInput;

    @FindBy(id = "billing_address_1")
    public static WebElement adressInput;

    @FindBy(id = "billing_postcode")
    public static WebElement postCodeInput;

    @FindBy(id = "billing_city")
    public static WebElement cityInput;

    @FindBy(id = "billing_phone")
    public static WebElement phoneInput;

    @FindBy(id = "billing_email")
    public static WebElement mailInput;

    @FindBy(id = "payment_method_cod")
    public static  WebElement radioButton;

    @FindBy(xpath = "//input[@data-value='Place order']")
    public static WebElement placeOrderButton;

    @FindBy(className = "woocommerce-error")
    public static WebElement errorMessage;

    @FindBy(className = "page-title")
    public static WebElement headerMessage;
}
