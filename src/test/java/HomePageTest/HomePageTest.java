package HomePageTest;


import BaseTest.BaseTest;
import SearchResultsTest.SearchResultsTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.SASHomePage;
import pages.common.SASSearchResultsPage;

public class HomePageTest extends BaseTest {

    SASSearchResultsPage searchResultsPage;



    @Test
    public void testSuccessfulSearch(){
        SoftAssert softAssert = new SoftAssert();
        SASSearchResultsPage searchRes = homePage.searchPerform("mochi");
        softAssert.assertTrue(searchRes.getSearchResultsHeader().contains("Հարցման որոնման արդյունքներ «mochi"));
    }

    @Test
    public void testHomePageLogo() {
        SoftAssert softAssert = new SoftAssert();
        homePage.clickHomePageButton();
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl, "https://www.sas.am");
    }
    @Test
    public void testNoSearchList(){
        SoftAssert softAssert = new SoftAssert();
        SASSearchResultsPage searchRes = homePage.searchPerform("blue cheese sauce");
        softAssert.assertEquals(searchRes.getSearchResults().size(), 0);
    }

    @Test
    public void testExistingSearchList(){
        SoftAssert softAssert = new SoftAssert();
        SASSearchResultsPage searchRes = homePage.searchPerform("blue cheese");
        softAssert.assertNotEquals(searchRes.getSearchResults().size(), 0);
    }

    @Test
    public static void testButtonClickAndPageNavigation() {
        SoftAssert softAssert = new SoftAssert();
        String currentUrl = driver.getCurrentUrl();
        SASSearchResultsPage searchRes = homePage.searchPerform("coca cola");
        String newUrl = driver.getCurrentUrl();
        softAssert.assertNotEquals(currentUrl, newUrl, "Page did not navigate after clicking the button");
    }
}

