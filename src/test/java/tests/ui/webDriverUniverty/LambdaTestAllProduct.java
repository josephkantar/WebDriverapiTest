package tests.ui.webDriverUniverty;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LambdaTestAllProduct extends BaseTest{
    @Ignore
    @Test
    public void testAllProduct() {
        lambdaTestPage
                .loadPage()
                .AppleViaMegaMenu()
                .gelenUrunlerinTolamDegeriniDogrula();
    }
    @Ignore
    @Test
    public void testAllProductWithSerachBox() {
        lambdaTestPage2
                .loadPage()
                .AppleViaMegaMenu()
                .verifySearchforMacBook();
    }

    @Test
    public void testAllProductSort() {
        lambdaTestPage2
                .loadPage()
                .AppleViaMegaMenu()
                .urunleriBuyuktenKucugeSiralaDogrula();

    }
}
