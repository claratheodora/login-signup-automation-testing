package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.SeleniumHelpers;
import java.time.Duration;

import java.time.Duration;

public class CompleteAccountPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public CompleteAccountPO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"id_field_email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"id_field_username\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"id_field_password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"id_field_dob\"]")
    private WebElement DateOfBirthField;

    @FindBy(xpath = "//*[contains(text(),'Complete Your Account')]")
    private WebElement txtCompleteYourAccount;

    @FindBy(xpath = "//*[contains(text(),'Welcome,')]")
    private WebElement txtWelcomeMessage;

    @FindBy(xpath = "//*[@id=\"id_btn_submit\"]")
    private WebElement btnSubmit;

    @FindBy(xpath = "//*[contains(text(),'Email has been registered')]")
    private WebElement txtEmailHasBeenRegistered;

    @FindBy(xpath = "//*[contains(text(),'Username has been taken')]")
    private WebElement txtUsernameHasBeenTaken;

    public void inputEmail(String word) {
        selenium.enterText(emailField, word, false);
    }

    public void inputUsername(String word) {
        selenium.enterText(usernameField, word, false);
    }

    public void inputPassword(String word) {
        selenium.enterText(passwordField, word, false);
    }

    public boolean isUserSeeCompleteYourAccountText() {
        return selenium.isElementDisplayed(txtCompleteYourAccount);
    }

    public void inputDateOfBirth(String date) {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        jse.executeScript("arguments[0].value='"+date+"';", DateOfBirthField);
    }

    public void clickSubmit() throws InterruptedException {
        selenium.click(btnSubmit);
    }

    public boolean isRedirectToHomepage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe("https://femaledaily.net/"));
        return true;
    }

    public boolean isUserSeeEmailHasBeenRegisteredText() {
        return selenium.isElementDisplayed(txtEmailHasBeenRegistered);
    }

    public boolean isUserSeeUsernameHasBeenTakenText() {
        return selenium.isElementDisplayed(txtUsernameHasBeenTaken);
    }

}
