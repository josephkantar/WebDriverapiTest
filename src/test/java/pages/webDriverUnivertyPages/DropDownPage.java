package pages.webDriverUnivertyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.BasePage;

public class DropDownPage extends BasePage {
    public DropDownPage(WebDriver driver) {
        super(driver);
    }
    public static Select select;
    @FindBy(id = "dropdowm-menu-1") private WebElement dropDown1;
    @FindBy(id = "dropdowm-menu-2") private WebElement dropDown2;
    @FindBy(id = "dropdowm-menu-3") private WebElement dropDown3;
    @FindBy(css = "[value='blue']") private WebElement radioButtonBlue;
    @FindBy(css = "[value='cabbage']:disabled") private WebElement cabbage;
    @FindBy(css = "[value='lettuce']") private WebElement lettuce;
    @FindBy(css = "[value='pumpkin']") private WebElement pumpkin;





    public DropDownPage selectPyhtonFromDropDownMenu1(){
        waitForVisibility(dropDown1);
        select=new Select(dropDown1);
        select.selectByVisibleText("Python");
        return this;
    }
    public DropDownPage selectTestNGFromDropDownMenu2(){
        waitForVisibility(dropDown2);
        select=new Select(dropDown2);
        select.selectByVisibleText("TestNG");
        return this;
    }
    public DropDownPage selectCSSFromDropDownMenu3(){
        waitForVisibility(dropDown3);
        select=new Select(dropDown3);
        select.selectByVisibleText("CSS");
        return this;
    }
    public DropDownPage selectRadioButtonBlue(){
        waitForVisibility(radioButtonBlue);
        if (!radioButtonBlue.isSelected()){
            radioButtonBlue.click();
        }
        return this;
    }
    public DropDownPage verifyCabbageDisabled(){
        Assert.assertFalse(cabbage.isEnabled());
        Assert.assertFalse(cabbage.isSelected());
        Assert.assertTrue(lettuce.isEnabled());
        Assert.assertFalse(lettuce.isSelected());
        Assert.assertTrue(pumpkin.isSelected());
        Assert.assertTrue(pumpkin.isEnabled());
        return  this;
    }
}
