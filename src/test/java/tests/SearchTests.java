package tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.*;

import java.io.IOException;

public class SearchTests extends BaseTest{
    @BeforeMethod
    public void setup() throws Exception {
        init("CHROME",30);
    }

    @AfterMethod
    public void tearDown(){
        quit();
    }

    @Test
    public void detailedSearch() throws IOException {
        driver.get("https://www.polovniautomobili.com/");

        HomePage homePage = new HomePage(driver);
        homePage.clickDetailedSearchButton();

        reportScreenshot("Test", "Test screenshot");

        DetailedSearchPage detailedSearchPage = new DetailedSearchPage(driver);
        detailedSearchPage.selectBrandByText("Alfa Romeo");
        detailedSearchPage.selectModelByText("Giulia");
        detailedSearchPage.checkOption("ABS");
        detailedSearchPage.checkOption("ASR");
        detailedSearchPage.enterPriceFrom("1000");

        assertEqualsText(driver.findElement(By.cssSelector("h1")),"Pretraga automobila","Text u naslovu h1 elementa se ne slaze");
    }

}
