package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CookieHomePage;
import tests.BaseTest;

public class BaseSteps extends BaseTest {

    @Before
    public void setup() throws Exception {
        init("CHROME",30);
    }

    @After
    public void tearDown(){
        quit();
    }

    @Given("I am on Cookie Clicker page")
    public void iAmOnCookieClickerPage() {
        driver.get("https://orteil.dashnet.org/cookieclicker/");
    }

    @And("I select English language")
    public void iSelectEnglishLanguage() {
        new CookieHomePage(driver).selectLanguageEN();
    }

    @When("I click cookie {int} times")
    public void iClickCookieTimes(int num) throws InterruptedException {
        new CookieHomePage(driver).clickCookie(num);
    }

    @Then("I should see upgrade is available")
    public void iShouldSeeUpgradeIsAvailable() {
        //TODO
    }

    @When("I buy the upgrade")
    public void iBuyTheUpgrade() {
        //TODO
    }

    @Then("I should see")
    public void iShouldSee() {
        //TODO
    }
}
