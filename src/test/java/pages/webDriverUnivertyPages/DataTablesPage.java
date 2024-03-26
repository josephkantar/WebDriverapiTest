package pages.webDriverUnivertyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DataTablesPage extends BasePage {
    public DataTablesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//thead//tr[1]") private WebElement allTitle;

    @FindBy(xpath = "//tbody//tr[1]//td[1]") private WebElement john;



    public DataTablesPage dataTableAllExercise(){
        System.out.println("john.getText() = " + john.getText());

        return this;
    }
}
