package BaseTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.OutputType;
import java.net.MalformedURLException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.common.SASHomePage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;


public class BaseTest {
    protected static RemoteWebDriver driver;
    protected static SASHomePage homePage;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
    }
    @BeforeMethod
    public void goHome() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(org.openqa.selenium.Platform.MAC);
        RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        homePage = new SASHomePage(driver);
        driver.get("https://www.sas.am");

    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File sc = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(sc.toPath(), new File("resources/screenshots/" + result.getName() + ".png").toPath());
            }
            catch (IOException err){
                err.printStackTrace();
            }
        }
    }
    @AfterClass
    public void tearDown(){
        // driver.quit();
    }
}
