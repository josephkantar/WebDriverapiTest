package pages.webDriverUnivertyPages;

import driver.DriverMngr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class IframePage extends BasePage {
    public IframePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "frame") private WebElement iframe;
    @FindBy(id = "button-find-out-more") private WebElement findOutMoreButton;
    @FindBy(xpath = "//*[contains(text(),'game')]") private WebElement happyMassage;

        public static String iframePageHandles;

    public IframePage clickFindOutMoreInIframeVerifyHappyMessage(){
        waitForVisibility(iframe);
        DriverMngr.getDriver().switchTo().frame(iframe);
        click(findOutMoreButton);
        waitForVisibility(happyMassage);
        assertThat(happyMassage.getText(),containsString("Welcome to webdriveruniversity.com "));
        DriverMngr.getDriver().switchTo().defaultContent();


        DriverMngr.getDriver().close();
        return this;
    }
    public HomePage goToHomePageAndRefresh(){
        switchToNewWindow(iframePageHandles);
        DriverMngr.getDriver().navigate().refresh();
        return new HomePage(driver);
    }



}
