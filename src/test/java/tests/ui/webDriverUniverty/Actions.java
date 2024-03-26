package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;

public class Actions extends BaseTest{
    @Test
    public void testActions() {
        homePage
                .loadPage()
                .clickActionsButtonSwitchToNewPage();
        actionsPage
                .dragAndDrop()
                .verifyDropMessage()
                .buttonDoubleClickAndVerify()
                .hoverOverAndClickLink2();

    }
}
