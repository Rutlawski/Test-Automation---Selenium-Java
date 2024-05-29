package org.example.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage {
    @FindBy(css = "#post-104 > .entry-header")
    public static WebElement firstProductCard;

    @FindBy(xpath = "//h1[@class='page-title']")
    public static WebElement searchErrorMessage;
}
