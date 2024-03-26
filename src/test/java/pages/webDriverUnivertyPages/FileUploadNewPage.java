package pages.webDriverUnivertyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FileUploadNewPage extends BasePage {
    public FileUploadNewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "myFile") private WebElement myFileButton;
    @FindBy(id = "submit-button") private WebElement gonderButton;



    public FileUploadNewPage addFileToNewPage(){
        waitForVisibility(myFileButton);
        myFileButton.sendKeys("C:\\Users\\LENOVO\\Desktop\\Yeni Metin Belgesi.txt");
        click(gonderButton);
        assertThat(driver.switchTo().alert().getText(),containsString("uploaded!"));
        assertThat(driver.switchTo().alert().getText(),equalTo("Your file has now been uploaded!"));
        driver.switchTo().alert().accept();

        return this;
    }
}
