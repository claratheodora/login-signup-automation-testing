package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.AccountPO;
import pageObject.CompleteAccountPO;
import pageObject.HomePO;
import pageObject.SignupPO;
import tests.TestBase;
import utility.Helpers;
import utility.SeleniumHelpers;

import java.util.Random;

public class Step extends TestBase {

    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private AccountPO accountPage = new AccountPO(driver);
    private SignupPO signupPage = new SignupPO(driver);
    private CompleteAccountPO completeAccountPage = new CompleteAccountPO(driver);
    private HomePO homePage = new HomePO(driver);

    @Given("User navigate to login or signup page")
    public void userNavigateToLoginOrSignupPage() {
        selenium.navigateToPage("https://account.femaledaily.net/");
    }

    @When("User input {string}")
    public void userInput(String arg0) {
        accountPage.inputEmail(arg0);
    }

    @And("User click login button")
    public void userClickLoginButton() throws InterruptedException {
        accountPage.clickLogin();
    }

    @And("User input password {string}")
    public void userInputPassword(String arg0) {
        accountPage.inputPassword(arg0);
    }

    @Then("User see popup account not found")
    public void userSeePopupAccountNotFound() {
        Assert.assertTrue(accountPage.isUserSeeAccountNotFoundText());
    }

    @When("User click signup button")
    public void userClickSignupButton() throws InterruptedException {
        accountPage.clickSignup();
    }

    @And("User see create new account")
    public void userSeeCreateNewAccount() throws InterruptedException {
        accountPage.isUserSeeCreateNewAccountText();
    }

    @Given("User navigate to signup page")
    public void userNavigateToSignupPage() {
        selenium.navigateToPage("https://account.femaledaily.net/register");
    }

    @When("User fill phone number {string}")
    public void userFillPhoneNumber(String arg0) {
        signupPage.inputPhoneNumber(arg0);
    }

    @And("User click sign up button")
    public void userClickSignUpButton() throws InterruptedException {
        signupPage.clickSignup();
    }

    @And("User fill OTP {string}")
    public void userFillOTP(String arg0) {
        signupPage.inputOtp(arg0);
    }

    @When("User fill phone number with {string}")
    public void userFillPhoneNumberWith(String arg0) {
        if (arg0.equals("random_phone_number")) {
            Faker faker = new Faker();
            String phoneNumber = faker.phoneNumber().subscriberNumber(10);
            signupPage.inputPhoneNumber(phoneNumber);
        } else {
            signupPage.inputPhoneNumber(arg0);
        }
    }

    @And("Click confirm button")
    public void clickConfirmButton() throws InterruptedException {
        signupPage.clickConfirm();
    }

    @Then("User will see completing profile page")
    public void userWillSeeCompletingProfilePage() {
        Assert.assertTrue(completeAccountPage.isUserSeeCompleteYourAccountText());
    }

    @When("User fill email with {string}")
    public void userFillEmailWith(String arg0) {
        if (arg0.equals("random_email")) {
            Faker faker = new Faker();
            String email = faker.internet().safeEmailAddress();
            completeAccountPage.inputEmail(email);
        } else {
            completeAccountPage.inputEmail(arg0);
        }
    }

    @And("User input date of birth {string}")
    public void userInputDateOfBirth(String date) {
        completeAccountPage.inputDateOfBirth(date);
    }

    @And("User fill username with {string}")
    public void userFillUsernameWith(String arg0) {
        if (arg0.equals("random_username")) {
            Faker faker = new Faker();
            String username = faker.name().username();
            username = username.replace(".", "");
            completeAccountPage.inputUsername(username);
        } else {
            completeAccountPage.inputUsername(arg0);
        }
    }

    @And("User fill password with {string}")
    public void userFillPasswordWith(String arg0) {
        if (arg0.equals("random_password")) {
            Helpers helpers = new Helpers();
            completeAccountPage.inputPassword(helpers.randomString());
        } else {
            completeAccountPage.inputPassword(arg0);
        }
    }

    @And("User click submit button")
    public void userClickSubmitButton() throws InterruptedException {
        completeAccountPage.clickSubmit();
    }

    @Then("Register successfully user redirect to homepage")
    public void registerSuccessfullyUserRedirectToHomepage() {
        Assert.assertTrue(completeAccountPage.isRedirectToHomepage());
    }

    @And("User see button verify now")
    public void userSeeButtonVerifyNow() {
        Assert.assertTrue(homePage.isUserSeeVerifyYourAccountText());
    }

    @Then("Error message please enter your correct phone number appear")
    public void errorMessagePleaseEnterYourCorrectPhoneNumberAppear() {
        Assert.assertTrue(signupPage.isUserSeeInccorectPhoneNumberText());
    }

    @Then("User see popup phone number has been registered")
    public void userSeePopupPhoneNumberHasBeenRegistered() {
        Assert.assertTrue(signupPage.isUserSeePopupRegisteredPhoneNumber());
    }

    @Then("Error message email has been registered appear")
    public void errorMessageEmailHasBeenRegisteredAppear() {
        Assert.assertTrue(completeAccountPage.isUserSeeEmailHasBeenRegisteredText());
    }

    @Then("Error message username has been taken appear")
    public void errorMessageUsernameHasBeenTakenAppear() {
        Assert.assertTrue(completeAccountPage.isUserSeeUsernameHasBeenTakenText());
    }

    @And("User input login password {string}")
    public void userInputLoginPassword(String arg0) {
        accountPage.inputPassword(arg0);
    }

    @Then("User redirect to home page")
    public void userRedirectToHomePage() {
        Assert.assertTrue(accountPage.isRedirectToHomepage());
    }

    @Then("User see popup phone number is not registered")
    public void userSeePopupPhoneNumberIsNotRegistered() {
        Assert.assertTrue(accountPage.isUserSeePhoneNotRegistered());
    }

    @And("User logout")
    public void userLogout() {
        selenium.navigateToPage("https://account.femaledaily.net/logout");
    }

    @And("User fill login OTP {string}")
    public void userFillLoginOTP(String arg0) {
        accountPage.inputOtp(arg0);
    }

    @And("Click confirm login button")
    public void clickConfirmLoginButton() throws InterruptedException {
        accountPage.clickConfirm();
    }
}
