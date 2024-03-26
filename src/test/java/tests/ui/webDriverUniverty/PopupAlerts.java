package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;

public class PopupAlerts extends BaseTest {
    @Test
    public void testName() {
        homePage
                .loadPage()
                .clickPopupAlertsButtonSwitchToNewPage();
        popupAlertsPage
                .clickButtonClick1AndVerifyAllerMessage()
                .clickButton3Click1AndVerifyAllerMessage();


    }
    @Test
    public void testName2() {
        homePage
                .loadPage()
                .clickPopupAlertsButtonSwitchToNewPage();
        popupAlertsPage
                .clickButtonClick4VerifyConfirmBoxMessage();

    }

}
