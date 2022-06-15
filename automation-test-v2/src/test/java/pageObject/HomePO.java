package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.SeleniumHelpers;

public class HomePO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public HomePO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"btn_verifynow\"]")
    private WebElement btnVerifyNow;

    public boolean isUserSeeVerifyYourAccountText() {
        new WebDriverWait(this.driver, 10)
                .until(ExpectedConditions.visibilityOf(btnVerifyNow));
        return selenium.isElementDisplayed(btnVerifyNow);
    }

}
