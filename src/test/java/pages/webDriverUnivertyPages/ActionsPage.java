package pages.webDriverUnivertyPages;

import driver.DriverMngr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ActionsPage extends BasePage {
    public ActionsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[text()='DRAG ME TO MY TARGET!']") private WebElement drag;
    @FindBy(xpath = "//*[text()='DROP HERE!']") private WebElement drop;
    @FindBy(xpath = "//*[text()='Dropped!']") private WebElement dropMessage;
    @FindBy(css = "#double-click") private WebElement doubleClick;
    @FindBy(xpath = "//*[text()='Hover Over Me Third!']") private WebElement hoverOver;
    @FindBy(xpath = "//*[@style='float:right;']//a/following-sibling::a") private WebElement link2;


    public ActionsPage dragAndDrop(){
        waitForVisibility(drag);
        actions.dragAndDrop(drag,drop).perform();
        return this;
    }
    public ActionsPage verifyDropMessage(){
        waitForVisibility(dropMessage);
        Assert.assertTrue(dropMessage.isDisplayed());
        assertThat(dropMessage.getText(),equalTo("Dropped!"));
        return this;
    }
    public ActionsPage buttonDoubleClickAndVerify(){
        waitForVisibility(doubleClick);
        actions.doubleClick(doubleClick).perform();
        assertThat(doubleClick.getAttribute("class"),containsString("double"));
        return this;
    }
    public ActionsPage hoverOverAndClickLink2(){
        waitForVisibility(hoverOver);
        actions.moveToElement(hoverOver).perform();
        click(link2);
        DriverMngr.getDriver().switchTo().alert().accept();
        return this;
    }


}
