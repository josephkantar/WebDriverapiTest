package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;

public class Iframe extends BaseTest{
    @Test
    public void testIframe() {
        homePage
                .loadPage()
                .clickIframeButtonSwitchToNewPage();
        iframePage
                .clickFindOutMoreInIframeVerifyHappyMessage()
                .goToHomePageAndRefresh();
    }

}
