package org.example.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
    @FindBy(id = "search-field-top-bar")
    public static WebElement searchInput;

    @FindBy(id = "search-top-bar-submit")
    public static WebElement searchButton;

    @FindBy(xpath = "//a[@data-product_id='17']")
    public static WebElement addToCartButton;

    @FindBy(className = "top-cart")
    public static  WebElement cartHeader;

    @FindBy(className = "top-account")
    public static WebElement myAccountButton;

    @FindBy(xpath = "//a[contains(text(), 'Generic Shop')]")
    public static WebElement genericShopButton;
}
