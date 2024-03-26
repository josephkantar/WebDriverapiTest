package pages.thyPages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;
import pages.webDriverUnivertyPages.HomePage;

import static constants.FrameworkConstants.getHomepageUrl;

public class DatePage extends BasePage {
    public DatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='general-booker-datapicker']") private WebElement tarihButton;
    @FindBy(xpath = "(//div[contains(@class,'today')])[1]/div") private WebElement todayDate;
    @FindBy(xpath = "(//div[contains(@aria-label,'16')])[1]") private WebElement yesterdayDate;
    int yesterday=Integer.parseInt(createDayWithDateFormatter())-1;
    String xPath="(//div[contains(@aria-label,'"+yesterday+"')])[1]";

    int tomorrow=Integer.parseInt(createDayWithDateFormatter())+1;
    String xPathtomorrow="(//div[contains(@aria-label,'"+tomorrow+"')])[1]";




    public DatePage loadPage(){
        navigateTo_URL("https://www.turkishairlines.com/tr-int/");
        return this;
    }
    public DatePage verifyDateTodayAndSelectedEnabledDisabled(){
        Assert.assertTrue(todayDate.isEnabled());
        Assert.assertEquals(todayDate.getAttribute("aria-disabled"),"false");
        click(tarihButton);
        Assert.assertEquals(createDayWithDateFormatter(),todayDate.getText());
        Assert.assertEquals(createYearWithYearFormatter(),todayDate.getAttribute("aria-label").substring(7,11));
        return this;
    }
    public DatePage verifyDateYesterdayAndSelectedEnabledDisabled(){
        Assert.assertEquals(driver.findElement(By.xpath(xPath)).getAttribute("aria-disabled"),"true");
        Assert.assertTrue(driver.findElement(By.xpath(xPath)).getAttribute("class").contains("disabled"));
        Assert.assertFalse(driver.findElement(By.xpath(xPath)).isSelected());
        Assert.assertEquals(driver.findElement(By.xpath(xPath)).getAttribute("aria-disabled"),"true");
        Assert.assertEquals(String.valueOf(yesterday),driver.findElement(By.xpath(xPath)).getText());
        Assert.assertTrue(driver.findElement(By.xpath(xPath)).getAttribute("aria-label").contains(String.valueOf(yesterday)));
        return this;
    }
    public DatePage verifyDateTomorrowAndSelectedEnabledDisabled(){
        Assert.assertEquals(driver.findElement(By.xpath(xPathtomorrow)).getAttribute("aria-disabled"),"true");
        Assert.assertFalse(driver.findElement(By.xpath(xPath)).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath(xPath)).isEnabled());
        Assert.assertEquals(driver.findElement(By.xpath(xPathtomorrow)).getText(),String.valueOf(tomorrow));
        //Assert.assertTrue(driver.findElement(By.xpath(xPathtomorrow)).getAttribute("aria-label").contains(String.valueOf(xPathtomorrow)));
        return this;
    }
}
