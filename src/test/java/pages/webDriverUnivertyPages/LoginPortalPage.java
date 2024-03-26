package pages.webDriverUnivertyPages;

import driver.DriverMngr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LoginPortalPage extends BasePage {
    public LoginPortalPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#text") private WebElement userNameInput;
    @FindBy(xpath = "//*[@id='password']") private WebElement passwordInput;
    @FindBy(id = "login-button") private WebElement loginButton;








    public LoginPortalPage enterUserName(String userName){
        enterText(userNameInput,userName);
        return this;
    }
    public LoginPortalPage enterPassword(String password){
        enterText(passwordInput,password);
        return this;
    }
    public LoginPortalPage clickLoginButton(){
        click(loginButton);
        return this;
    }
    public LoginPortalPage veriyfAllertMessage(){
        DriverMngr.getDriver().switchTo().alert().getText();
        assertThat(DriverMngr.getDriver().switchTo().alert().getText(),containsString("validation"));
        DriverMngr.getDriver().switchTo().alert().accept();
        return  this;
    }

}
