package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.SeleniumHelpers;

import java.time.Duration;

public class AccountPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public AccountPO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"id_field_login\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"id_field_pass\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"id_btn_login\"]")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"id_btn1_signup\"]")
    private WebElement btnSignup;

    @FindBy(xpath = "//*[contains(text(),'Uh-oh! Account not found!')]")
    private WebElement txtAccountNotFound;

    @FindBy(xpath = "//*[contains(text(),'Create New Account')]")
    private WebElement txtCreateNewAccount;

    @FindBy(xpath = "//*[contains(text(),'Phone number is not registered')]")
    private WebElement txtPhoneNotRegistered;

    @FindBy(xpath = "//*[@id=\"id_code_login\"]")
    private WebElement otpField;

    @FindBy(xpath = "//*[@id=\"id_confirm_login\"]")
    private WebElement btnConfirm;

    public void inputEmail(String word) {
        selenium.enterText(emailField, word, false);
    }

    public void inputPassword(String word) {
        selenium.enterText(passwordField, word, false);
    }

    public void clickLogin() throws InterruptedException {
        selenium.click(btnLogin);
    }

    public void clickSignup() throws InterruptedException {
        selenium.click(btnSignup);
    }

    public boolean isUserSeeAccountNotFoundText() {
        return selenium.isElementDisplayed(txtAccountNotFound);
    }

    public boolean isUserSeeCreateNewAccountText() {
        new WebDriverWait(this.driver, 10).until(ExpectedConditions.visibilityOf(txtCreateNewAccount));
        return selenium.isElementDisplayed(txtCreateNewAccount);
    }

    public boolean isRedirectToHomepage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlToBe("https://femaledaily.net/"));
        return true;
    }

    public boolean isUserSeePhoneNotRegistered() {
        return selenium.isElementDisplayed(txtPhoneNotRegistered);
    }

    public void inputOtp(String word) {
        selenium.enterText(otpField, word, false);
    }

    public void clickConfirm() throws InterruptedException {
        selenium.click(btnConfirm);
    }
}
