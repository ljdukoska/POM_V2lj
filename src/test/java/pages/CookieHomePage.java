package pages;

import helpers.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CookieHomePage extends CommonActions {

    WebDriver driver;

    public CookieHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#bigCookie")
    WebElement cookie;
    @FindBy(css = "#langSelect-EN")
    WebElement languageEN;

    public void clickCookie(String num) throws InterruptedException {
        for (int i = 1; i <=Integer.parseInt(num);i++) {
            clickElement(cookie);
            Thread.sleep(50);
        }
    }

    public void selectLanguageEN(){
        clickElement(languageEN);
    }

    public void verifyProductIsAvailable(String product){
        Assert.assertEquals(driver.findElement(By.cssSelector("#"+product)).getAttribute("class"),"product unlocked enabled");
    }

    public void clickProduct(String product){
        clickElement(driver.findElement(By.cssSelector("#"+product)));
    }

    public void verifyUpgradesAreAvailable(String ... upgrades){
        for (String upgrade:upgrades) {
            Assert.assertTrue(driver.findElement(By.cssSelector("#"+upgrade)).isDisplayed());
        }
    }

    public void verifyNotes(String ... notes) throws InterruptedException {
        for (String note:notes) {
            System.out.println(note);
            Thread.sleep(1000);
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id='"+note+"']//h3")).isDisplayed());
        }
    }
}
