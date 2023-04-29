package SearchResultsTest;

import BaseTest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.common.SASHomePage;
import pages.common.SASItem;
import pages.common.SASSearchResultsPage;

public class SearchResultsTest extends BaseTest {

   @Test
    public void searchForItem(){
       SoftAssert softAssert = new SoftAssert();
       SASSearchResultsPage searchResults  = homePage.searchPerform("mochi");
       SASItem searchItem = searchResults.navigateToItem("Պաղպաղակ կարամելի «WAO Mochi» 210գ");
       softAssert.assertTrue(searchItem.getItemCodeValue().equals(297055));
   }


    @Test
    public static void navigationTest() {
        SoftAssert softAssert = new SoftAssert();
        SASSearchResultsPage searchRes = homePage.searchPerform("mochi");
        String currentUrl = driver.getCurrentUrl();
        SASItem sasItem = searchRes.navigateToItem("Պաղպաղակ կարամելի «WAO Mochi» 210գ");
        String newUrl = driver.getCurrentUrl();
        softAssert.assertNotEquals(currentUrl, newUrl, "Navigations didnt work");
    }



}
