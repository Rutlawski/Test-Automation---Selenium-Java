package org.example.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    @FindBy(css = ".product-price > .woocommerce-Price-amount")
    public static WebElement price;

    @FindBy(className = "dashicons-minus")
    public static WebElement minusButton;

    @FindBy(className = "dashicons-plus")
    public static WebElement plusButton;

    @FindBy(xpath = "//input[@name='update_cart']")
    public static WebElement updateCartButton;

    @FindBy(className = "cart-empty")
    public static WebElement emptyCartMessage;

    @FindBy(className = "checkout-button")
    public static WebElement checkoutButton;
}
