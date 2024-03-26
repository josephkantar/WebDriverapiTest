package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;

import static utils.BrowserUtils.waitFor;

public class FileUploadNew extends BaseTest{
    @Test
    public void testFileUploadNew() {
        homePage
                .loadPage()
                .clickFileUploadButtonSwitchToNewPage();
        fileUploadNewPage
                .addFileToNewPage();
        waitFor(3);

    }
}
