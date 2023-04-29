package pages.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import constants.locators.SASSearchResultsPageConstants;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static constants.locators.SASItemConstants.searchItemCode;
import static constants.locators.SASItemConstants.searchItemImage;

public class SASSearchResultsPage {
    private WebDriver driver;
    private SASItem sasItem;
    private WebDriverWait wait;
    private By searchResults = By.className(SASSearchResultsPageConstants.searchResults);
    private By searchResHeader = By.className(SASSearchResultsPageConstants.searchResHeader);

    private By searchResultsTitle = By.xpath(SASSearchResultsPageConstants.searchResultsTitle);
    private By searchResultsTitleSubTitle = By.xpath(SASSearchResultsPageConstants.searchResultsSubTitle);


    public SASSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSearchResultsHeader() {
        return driver.findElement(searchResHeader).getText();

    }
    public List<WebElement> getSearchResults() {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
        return driver.findElements(searchResults);

    }

    public void GetSpecificResult(String name) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchResults));
        List<WebElement> results = getSearchResults();
        for (WebElement result : results) {
            System.out.println(result.findElement(searchResultsTitle).findElement(searchResultsTitleSubTitle).getText());
            if (result.findElement(searchResultsTitle).findElement(searchResultsTitleSubTitle).getText().equals(name)) {
                sasItem.getItemImage().click();

            }
        }
    }


    public boolean checkCaptions(String keyword)
        {
            List<WebElement> results = getSearchResults();
            for(WebElement result : results){
                if (result.findElement(searchResultsTitle).findElement(searchResultsTitleSubTitle).getText().equals(keyword)) {
                        return true;
                    }
            }
                return false;
        }



    public SASItem navigateToItem(String name ){
        if(checkCaptions(name)== true){
            GetSpecificResult(name);
        }
        return new SASItem(driver);
    }
}