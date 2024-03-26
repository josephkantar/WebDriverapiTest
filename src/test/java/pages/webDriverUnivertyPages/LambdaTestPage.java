package pages.webDriverUnivertyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.FrameworkConstants.getHomepageUrl;

public class LambdaTestPage extends BasePage {
    public LambdaTestPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//li[contains(@class,'mega-menu')]") private WebElement megaMenu;
    @FindBy(css = "[title='Apple']") private WebElement apple;
    @FindBy(xpath = "//a[@class=\"text-ellipsis-2\"]") private List<WebElement> allProductElement;
    @FindBy(css = "[class='col-sm-6 text-right']") private WebElement totalPagesText;
    @FindBy(xpath = "//a[text()=\">\"]") private WebElement nextButton;


    public LambdaTestPage loadPage() {
        navigateTo_URL("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        return this;
    }
    public LambdaTestPage AppleViaMegaMenu(){
        hoverOver(megaMenu);
        click(apple);
        return this;
    }
    public LambdaTestPage gelenUrunlerinTolamDegeriniDogrula(){

        List<String> allProductList=new ArrayList<>();
        scrollDownByJS();
        String totalText=totalPagesText.getText();
        int page=extractPagesNumber(totalText);
        for (WebElement each:allProductElement){
            allProductList.add(each.getText());
        }
        for (int i = 1; i <page ; i++) {
            click(nextButton);
            waitFor(2);

            for (WebElement each:allProductElement){
                allProductList.add(each.getText());
            }
            scrollDownByJS();
        }
        int allProductCount=extractProductCount(totalPagesText.getText());
        Assert.assertEquals(allProductCount,allProductList.size());
       // System.out.println("allProductList.size() = " + allProductList.size());

        //ürünlerden kaçartane olduğunu yazdırma
        Map<String,Integer> urunSayiMap=new HashMap<>();
        Integer eachSayisi;
        for (String each:allProductList){
            if (!urunSayiMap.containsKey(each)){
                urunSayiMap.put(each,1);
            }else {
                eachSayisi=urunSayiMap.get(each);
                urunSayiMap.put(each,eachSayisi+1);
            }
        }

        System.out.println(urunSayiMap);
        return this;
    }
    public int extractPagesNumber(String productInfoText) {
        // "Showing 1 to 10 of 35 (1 Pages)" gibi bir formattan sayıyı çıkarmak için regex kullanma
        Pattern pattern = Pattern.compile("Showing \\d+ to \\d+ of \\d+ \\((\\d+) Pages\\)");
        Matcher matcher = pattern.matcher(productInfoText);

        // Metindeki sayıları bul ve ilk bulunan sayıyı al
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(1));
        }

        return 0; // Hata durumu, uygun sayı bulunamadı
    }
    public int extractProductCount(String productInfoText) {
        // "Showing 1 to 10 of 35 (1 Pages)" gibi bir formattan sayıyı çıkarmak için regex kullanma
        Pattern pattern = Pattern.compile("Showing \\d+ to \\d+ of (\\d+) \\(\\d+ Pages\\)");
        Matcher matcher = pattern.matcher(productInfoText);

        // Metindeki sayıları bul ve ilk bulunan sayıyı al
        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0; // Hata durumu, uygun sayı bulunamadı
    }
}
