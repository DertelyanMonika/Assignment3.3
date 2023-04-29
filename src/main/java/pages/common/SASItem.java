package pages.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.*;
import constants.locators.SASItemConstants;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;


public class SASItem {
    private WebDriver driver;
    private By searchedItemTitle = By.className(SASItemConstants.searchedItemTitle);
    private By searchItemCode = By.xpath(SASItemConstants.searchItemCode);
    private By searchItemImage = By.className(SASItemConstants.searchItemImage);
    private By searchItemPrice = By.className(SASItemConstants.searchItemPrice);


    public SASItem(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getItem() {
        return driver.findElement(searchedItemTitle);
    }

    public String getItemTitle() {
        return driver.findElement(searchedItemTitle).getText();
    }
    public WebElement getItemCode() {

        return driver.findElement(searchItemCode);
    }

    public String getItemCodeValue() {
        return driver.findElement(searchItemCode).getText();
    }

    public WebElement getItemImage() {
        return driver.findElement(searchItemImage);
    }
    public WebElement getItemPrice() {

        return driver.findElement(searchItemPrice);
    }


}
