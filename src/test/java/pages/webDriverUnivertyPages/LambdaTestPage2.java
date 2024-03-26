package pages.webDriverUnivertyPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTestPage2 extends BasePage {
    public LambdaTestPage2(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//li[contains(@class,'mega-menu')]") private WebElement megaMenu;
    @FindBy(css = "[title='Apple']") private WebElement apple;
    @FindBy(xpath = "//div[@id='mz-filter-panel-0-1']//input") private WebElement searchBox;
    @FindBy(xpath = "//a[@class=\"text-ellipsis-2\"]") private List<WebElement> allProductElement;
    @FindBy(css = "[id='input-sort-212434']") private WebElement sortBy;
    @FindBy(css = "[class='price-new']") private List<WebElement> allProductPriceElement;

    public LambdaTestPage2 loadPage() {
        navigateTo_URL("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        return this;
    }
    public LambdaTestPage2 AppleViaMegaMenu(){
        hoverOver(megaMenu);
        click(apple);
        return this;
    }
    public LambdaTestPage2 verifySearchforMacBook(){
        //MacBook haricindeki datalar var mı listele yazdır kaçtane?
        enterText(searchBox,"macBook");
        actions.sendKeys(Keys.ENTER).perform();
        waitFor(2);

        List<String> differentProductList=new ArrayList<>();
        String urunName=" ";
        int count=0;
        for (WebElement each:allProductElement){
           urunName=each.getText();
           if (!urunName.contains("MacBook")){
               count++;
               differentProductList.add(urunName);
               System.out.println(urunName);
           }
        }
        System.out.println("toplam "+count+" Ürün Eşleşmiyor");
        System.out.println("differentProductList = " + differentProductList);
        return this;
    }
    public LambdaTestPage2 urunleriBuyuktenKucugeSiralaDogrula(){
        Select select=new Select(sortBy);
        select.selectByVisibleText("Price (High > Low)");
        waitFor(2);
        double [] myArry=new double[allProductPriceElement.size()];
        int i=0;
        for (WebElement each:allProductPriceElement){
            myArry[i]=Double.parseDouble(each.getText().substring(1).replaceAll(",",""));
            i++;
        }

        for (int j = 1; j < myArry.length ; j++) {
            if (myArry[j]>myArry[j-1]){
                System.out.println("Hatalı Sıralama mevcut");
            }
        }
        return this;
    }
}
