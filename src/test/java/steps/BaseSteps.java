package steps;

import excel.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CookieHomePage;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    @Before
    public void setup() throws Exception {
        init("CHROME",30);
    }

    @After
    public void tearDown(){
//        quit();
    }

    @Given("I am on Cookie Clicker page")
    public void iAmOnCookieClickerPage() {
        driver.get("https://orteil.dashnet.org/cookieclicker/");
    }

    @And("I select English language")
    public void iSelectEnglishLanguage() throws InterruptedException {
        new CookieHomePage(driver).selectLanguageEN();
        Thread.sleep(1000);
    }

    @When("I click cookie {string} times")
    public void iClickCookieTimes(String num) throws InterruptedException {
        new CookieHomePage(driver).clickCookie(num);
    }

    @Then("I should see {string} product is available")
    public void iShouldSeeP_roductIsAvailable(String productName) {
        new CookieHomePage(driver).verifyProductIsAvailable(productName);
    }

    @When("I buy the product {string}")
    public void iBuyTheProduct(String product) {
        new CookieHomePage(driver).clickProduct(product);
    }

    @Then("I should see {string} and {string}")
    public void iShouldSeeUpgradeAndUpgrade(String upgrade1, String upgrade2) {
        new CookieHomePage(driver).verifyUpgradesAreAvailable(upgrade1,upgrade2);
    }

    @And("I should see {string} {string} {string} {string}")
    public void iShouldSee(String note1, String note2,String note3,String note4) throws InterruptedException {
        new CookieHomePage(driver).verifyNotes(note1,note2,note3,note4);
    }

    @And("I should see {string}")
    public void iShouldSee(String upgrade1) {
        new CookieHomePage(driver).verifyUpgradesAreAvailable(upgrade1);

    }

    @And("I should see {string} {string}")
    public void iShouldSee(String note1, String note2) throws InterruptedException {
        new CookieHomePage(driver).verifyNotes(note1,note2);
    }

    @And("I read test data {string} {string} {string}")
    public void iReadTestData(String fileName, String sheetName, String row) throws IOException {
        data = new ExcelUtilities().getRowData(fileName,sheetName,Integer.parseInt(row));
    }

    @And("I print out data")
    public void iPrintOutData() {
        System.out.println(data.get("tc_id"));
    }
}
