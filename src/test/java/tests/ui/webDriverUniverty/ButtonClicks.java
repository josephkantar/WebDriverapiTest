package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;

public class ButtonClicks extends BaseTest{
    @Test
    public void testClickWithWebElement() {
        homePage
                .loadPage()
                .clickButtonClickSwitchToNewPage();
        buttonClickPage
                .clickButton1WithWebElement()
                .verifySuccessfullyMessage1();
    }
    @Test
    public void testClickWithJs() {
        homePage
                .loadPage()
                .clickButtonClickSwitchToNewPage();
        buttonClickPage
                .clickButton2WithJs();
    }
    @Test
    public void testClickWithAcctionsClass() {
        homePage
                .loadPage()
                .clickButtonClickSwitchToNewPage();
        buttonClickPage
                .clickButton3AcctionsClass()
                .verifySuccessfullyMessage3();
    }
}
