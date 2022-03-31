package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ForgotPasswordPageElements;
import pages.LoginPageElements;
import pages.StartFreeTrialPageElements;
import utilities.CommonMethods;
import utilities.ConfigFileReader;
import utilities.Driver;

import java.io.IOException;


public class LoginPageSteps {

    LoginPageElements loginPage = new LoginPageElements();
    StartFreeTrialPageElements startFreeTrialPage = new StartFreeTrialPageElements ();
    ForgotPasswordPageElements forgotPasswordPage = new ForgotPasswordPageElements();

    @Given("user navigates to Sysdig login page")
    public void user_navigates_to_sysdig_login_page() {
        Driver.getDriver().get(ConfigFileReader.getProperty("url"));
    }

    @When("user clicks on Region container")
    public void user_clicks_on_region_container() {
        loginPage.regionDropdownIndicator.click();
    }

    @When("user selects {string}")
    public void user_selects(String region) throws InterruptedException {
        loginPage.regionInput.sendKeys(region);
        CommonMethods.actionKeysEnter();
        Thread.sleep(3000);
    }

    @Then("navigates to related {string}")
    public void navigates_to_related(String URL) {
        Assert.assertEquals(URL, Driver.getDriver().getCurrentUrl());
    }

    @Then("selected {string} displays on Region container")
    public void selected_displays_on_region_container(String regionName) {
        Assert.assertEquals(regionName, loginPage.regionOptions(regionName).getText());
    }

    @When("user enter wrong credentials to email filed {string} and password filed {string}")
    public void user_enter_wrong_credentials_to_email_filed_and_password_filed(String email, String password) {
        loginPage.emailField.sendKeys(email);
        loginPage.passwordField.sendKeys(password);
    }

    @When("click to the log in button")
    public void click_to_the_log_in_button() {
        loginPage.LoginButton.click();
    }

    @Then("user see {string} error message")
    public void user_see_error_message(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.logInErrorMessage.getText());
    }

    @When("user clicks on the Google button under the Log in with separator")
    public void userClicksOnTheGoogleButtonUnderTheLogInWithSeparator() {
        loginPage.googleAuthentication.click();
    }

    @Then("on the redirected page {string} title displays")
    public void onTheRedirectedPageTitleDisplays(String title) {
        Assert.assertEquals(title,Driver.getDriver().getTitle());
    }

    @When("user clicks on the SAML button under the Log in with separator")
    public void userClicksOnTheSAMLButtonUnderTheLogInWithSeparator() {
        loginPage.samlAuthentication.click();
    }

    @Then("on the redirected page {string} URI displays")
    public void onTheRedirectedPageURIDisplays(String URI) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(URI));
    }

    @When("user clicks on the OpenID button under the Log in with separator")
    public void userClicksOnTheOpenIDButtonUnderTheLogInWithSeparator() {
        loginPage.openIdAuthentication.click();
    }

    @Then("{string} separator displays")
    public void separatorDisplays(String arg0) {
        Assert.assertTrue(loginPage.logInWithSeparator.isDisplayed());
    }

    @When("user clicks on Forgot your password link")
    public void userClicksOnForgotYourPasswordLink() {
        loginPage.forgotYourPasswordLink.click();
    }

    @Then("navigates to forgot password page")
    public void navigatesToForgotPasswordPage() {
        Assert.assertTrue(forgotPasswordPage.passwordResetButton.isDisplayed());
    }

    @When("user clicks on Sign up for a free trial link")
    public void userClicksOnSignUpForAFreeTrialLink() {
        loginPage.signUpForFreeTrialLink.click();
    }

    @Then("navigates to {string} heading")
    public void navigatesToHeading(String heading) {
        Assert.assertTrue(startFreeTrialPage.tryFreeSysdigHeading.isDisplayed());
    }
}
