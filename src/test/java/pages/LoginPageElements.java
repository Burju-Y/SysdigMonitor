package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPageElements {

    public LoginPageElements(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//div[contains(@class,'dropdown-indicator')]")
    public WebElement regionDropdownIndicator;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement LoginButton ;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotYourPasswordLink ;

    @FindBy(css = "div.block-login__separator")
    public WebElement logInWithSeparator ;

    @FindBy(xpath = "//a[contains(@href,'google')]")
    public WebElement googleAuthentication ;

    @FindBy(xpath = "//a[contains(@href,'saml')]")
    public WebElement samlAuthentication ;

    @FindBy(xpath = "//a[contains(@href,'openId')]")
    public WebElement openIdAuthentication ;

    @FindBy(xpath = "//div[@class='login__notes']")
    public WebElement notCustomerLabel ;

    @FindBy(linkText = "Sign up for a free trial!")
    public WebElement signUpForFreeTrialLink ;

    @FindBy(css = "p.login__error-display")
    public WebElement logInErrorMessage ;

    @FindBy(xpath = "//*[@id='react-select-2-input']")
    public WebElement regionInput ;

    public WebElement regionOptions(String region){
        return Driver.getDriver().findElement(By.xpath("//div[text()='"+region+"']"));
    }
}
