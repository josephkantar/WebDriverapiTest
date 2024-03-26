package pages.webDriverUnivertyPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import tests.ui.webDriverUniverty.DataTableButton;

import java.util.List;

public class DataTableButtonPage extends BasePage {
    public DataTableButtonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='t01']//tbody//tr[2]/td[1]")
    private WebElement jhon;
    @FindBy(xpath = "//*[@id='t01']//tbody//tr[2]")
    private List<WebElement> jhonList;
    @FindBy(xpath = "//*[@id='t01']//tbody//td[1]")
    private List<WebElement> allNameList;
    @FindBy(xpath = "//*[@id='t02']//tbody//td[2]")
    private List<WebElement> allLastNameList2;


    public DataTableButtonPage verifyAllData() {
        System.out.println("jhon = " + jhon.getText());
        System.out.println("jhonList.get(0).getText() = " + jhonList.get(0).getText());
        System.out.println("allNameList.get(0).getText() = " + allNameList.get(0).getText());
        //tüm sütunlar allName
        for (WebElement w : allNameList) {
            System.out.println("w.getText()+\" \" = " + w.getText() + " ");
            System.out.println();
        }
            //tüm LastNameList2 bilgileri
            for (WebElement a : allLastNameList2) {
                System.out.print(a.getText() + " ");
            }
            //lastName W başlayanı ver ise tertten yazıdır
            String ters = "";
            for (WebElement w : allLastNameList2) {
                if (w.getText().startsWith("w")) {
                    System.out.println("Buldum : " + w.getText());
                    ters = w.getText();
                }
            }
            for (int i = ters.length(); i > 0; i--) {
                System.out.print(ters.substring(i - 1, i));
            }
            return this;
        }


    }
