package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;

public class DataTableButton extends BaseTest{
    @Test
    public void testDataTableButton() {
        homePage
                .loadPage()
                .clickDataTableButtonSwitchToNewPage();
        dataTableButtonPage
                .verifyAllData();

    }
}
