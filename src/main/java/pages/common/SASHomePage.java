package pages.common;

import constants.locators.SASHomePageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;



import constants.locators.SASHomePageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SASHomePage {
        private WebDriver driver;
        private By search_field = By.name(SASHomePageConstants.search_field);
        private By search_icon = By.xpath(SASHomePageConstants.search_icon);
        private By pageLogo = By.className(SASHomePageConstants.pageLogo);

        public SASHomePage(WebDriver driver) {
            this.driver = driver;
        }


        public void fillSearchField(String input) {
            WebElement field = driver.findElement(search_field);
            field.sendKeys(input);
        }

        public void clickSearchButton() {
            WebElement searchButton = driver.findElement(search_icon);
            searchButton.click();
        }

        public void clickHomePageButton() {
            WebElement homePageButton = driver.findElement(pageLogo);
            homePageButton.click();
        }

        public SASSearchResultsPage searchPerform(String input) {
            fillSearchField(input);
            clickSearchButton();
            return new SASSearchResultsPage(driver);
        }

    }




