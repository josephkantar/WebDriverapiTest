package pages.webDriverUnivertyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ButtonClickPage extends BasePage {
    public ButtonClickPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[text()='CLICK ME!']") private WebElement click1;
    @FindBy(xpath = "//*[contains(text(),'successfully')]") private WebElement message1;
    @FindBy(xpath = "//div[@id='myModalClick']//button[text()='Close']") private WebElement closeButton1;
    @FindBy(id = "button2") private WebElement click2;
    @FindBy(xpath = "//*[contains(text(),'Remember ')]") private WebElement message2;
    @FindBy(xpath = "//div[@class='modal fade in show']//button[text()='Close']") private WebElement closeButton2;
    @FindBy(id = "button3") private WebElement click3;
    @FindBy(xpath = "//*[text()=' can become very useful!']") private WebElement message3;
    @FindBy(xpath = "//div[@class='modal fade in show']//button[text()='Close']") private WebElement closeButton3;





    public ButtonClickPage clickButton1WithWebElement(){
        click(click1);
        return this;
    }
    public ButtonClickPage verifySuccessfullyMessage1(){
        waitForVisibility(message1);
        Assert.assertTrue(message1.isDisplayed());
        assertThat(message1.getText(),containsString("successfully"));
        click(closeButton1);
        return this;
    }
    public ButtonClickPage clickButton2WithJs(){
        clickElementByJS(click2);
        return this;
    }
    public ButtonClickPage verifySuccessfullyMessage2(){
        waitForVisibility(message2);
        Assert.assertTrue(message2.isDisplayed());
        assertThat(message2.getText(),containsString("Remember"));
       clickElementByJS(closeButton2);
        return this;
    }
    public ButtonClickPage clickButton3AcctionsClass(){
        waitForClickable(click3);
        actions.click(click3).perform();
        return this;
    }
    public ButtonClickPage verifySuccessfullyMessage3(){
        waitForVisibility(message3);
        Assert.assertTrue(message3.isDisplayed());
        assertThat(message3.getText(),containsString("become"));
        actions.click(closeButton3).perform();
        return this;
    }



}
