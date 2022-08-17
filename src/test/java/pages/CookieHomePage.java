package pages;

import helpers.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void clickCookie(int num) throws InterruptedException {
        for (int i = 1; i <=num;i++) {
            clickElement(cookie);
            Thread.sleep(100);
        }
    }

    public void selectLanguageEN(){
        clickElement(languageEN);
    }

}
