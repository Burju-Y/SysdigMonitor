package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StartFreeTrialPageElements {

    public StartFreeTrialPageElements(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[text()='Try Sysdig for Free']")
    public WebElement tryFreeSysdigHeading ;
}
