package pages.webDriverUnivertyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PopupAlertsPage extends BasePage {
    public PopupAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "button1") private WebElement click1;
    @FindBy(id = "button3") private WebElement click3;
    @FindBy(xpath = "//*[contains(text(),'exercise')]") private WebElement wellDoneHappyMessage;
    @FindBy(css = "button[class='btn btn-default']") private WebElement closeButton;
    @FindBy(id = "button4") private WebElement click4;
    @FindBy(xpath = "//*[text()='You pressed OK!']") private WebElement youPressedOkMessage;


    public PopupAlertsPage clickButtonClick1AndVerifyAllerMessage(){
        waitForVisibility(click1);
        click(click1);
        assertThat(driver.switchTo().alert().getText(),equalTo("I am an alert box!"));
        driver.switchTo().alert().accept();
        //driver.close();


        return this;
    }
    public PopupAlertsPage clickButton3Click1AndVerifyAllerMessage(){
        click(click3);
        click(click1);

        //assertThat(driver.switchTo().alert().getText(),equalTo("I am an alert box!"));
        //driver.switchTo().alert().accept();
        //driver.close();


        return this;
    }
    public PopupAlertsPage clickButtonClick3VerifyPopupMessage(){
        click(click3);
        click(click1);
        waitForVisibility(wellDoneHappyMessage);
        assertThat(wellDoneHappyMessage.getText(),containsString("exercise will hopefully"));
        click(closeButton);

        return this;
    }
    public PopupAlertsPage clickButtonClick4VerifyConfirmBoxMessage(){
        waitForVisibility(click4);
        click(click4);
        assertThat(driver.switchTo().alert().getText(),equalTo("Press a button!"));
        driver.switchTo().alert().accept();
        assertThat(youPressedOkMessage.getText(),equalTo("You pressed OK!"));

        return this;
    }
}
