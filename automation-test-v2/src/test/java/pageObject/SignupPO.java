package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utility.SeleniumHelpers;

public class SignupPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public SignupPO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"id_field_signup\"]")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id=\"id_code_signup\"]")
    private WebElement otpField;

    @FindBy(xpath = "//*[@id=\"id_btn2_signup\"]")
    private WebElement btnSignup;

    @FindBy(xpath = "//*[@id=\"id_confirm_signup\"]")
    private WebElement btnConfirm;

    @FindBy(xpath = "//*[contains(text(),'Please enter your correct phone number')]")
    private WebElement txtIncorrectPhoneNumber;

    @FindBy(xpath = "//*[contains(text(),'Phone number has been registered')]")
    private WebElement txtPhoneNumberRegistered;

    public void inputPhoneNumber(String word) {
        selenium.enterText(phoneNumberField, word, false);
    }

    public void inputOtp(String word) {
        selenium.enterText(otpField, word, false);
    }

    public void clickSignup() throws InterruptedException {
        selenium.click(btnSignup);
    }

    public void clickConfirm() throws InterruptedException {
        selenium.click(btnConfirm);
    }

    public boolean isUserSeeInccorectPhoneNumberText() {
        return selenium.isElementDisplayed(txtIncorrectPhoneNumber);
    }

    public boolean isUserSeePopupRegisteredPhoneNumber(){
        return selenium.isElementDisplayed(txtPhoneNumberRegistered);
    }

}
