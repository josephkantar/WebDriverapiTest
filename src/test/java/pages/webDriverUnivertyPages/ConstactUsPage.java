package pages.webDriverUnivertyPages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class ConstactUsPage extends BasePage {
    public ConstactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='first_name']") private WebElement firstNameInput;
    @FindBy(css = "[name='last_name']") private WebElement lastNameInput;
    @FindBy(css = "[name='email']") private WebElement emailInput;
    @FindBy(css = "[name='message']") private WebElement commentInput;
    @FindBy(css = "[type='submit']") private WebElement submitButton;
   // @FindBy(xpath = "//*[text()='Thank You for your Message!']") private WebElement messageText;
    @FindBy(xpath = "//*[contains(text(),'Thank')]") private WebElement messageText;



    public ConstactUsPage enterFirstName(String name){
        enterText(firstNameInput,name);
        return this;
    }
    public ConstactUsPage enterLastName(String name){
        enterText(lastNameInput,name);
        return this;
    }
    public ConstactUsPage enterEmail(){
        String email=faker.internet().emailAddress();
        Allure.step("Kullanıcı "+email+" girer.");
        enterText(emailInput,email);
        return this;
}
    public ConstactUsPage enterMessage(){
        String message="Nescafe bile 3 ü 1 arada ben ise hala yanlızım.";
        Allure.step("Kullanıcı "+message+" girer.");
        enterText(commentInput,message);
        return this;
    }
    public ConstactUsPage clickSubmitButton(){
        click(submitButton);
        return this;
    }
    public ConstactUsPage verifyThankYouForYourMessage(){
        waitForVisibility(messageText);
        Assert.assertTrue(messageText.isDisplayed());
        return this;
    }

}
