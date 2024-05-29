package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
    @FindBy(id = "search-field-top-bar")
    public static WebElement searchInput;

    @FindBy(id = "search-top-bar-submit")
    public static WebElement searchButton;
}
