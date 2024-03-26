package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;
import utils.ConfigurationReaderFile;

import static constants.FrameworkConstants.getValidemail;
import static constants.FrameworkConstants.getValidpassword;
import static utils.BrowserUtils.waitFor;

public class AutomationFileDownLoad extends BaseTest{
    @Test
    public void testFileDownLoad() {
        fileDownLoadPage
                .loadPage()
                .login(getValidemail(),getValidpassword())
                .addProductGoToCart()
                .cratePAymentVeify()
                .verifyFileDownLoadPaper();
        waitFor(3);
    }
}
