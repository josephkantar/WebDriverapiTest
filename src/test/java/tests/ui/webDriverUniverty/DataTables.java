package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;

public class DataTables extends BaseTest{
    @Test
    public void testDataTables() {
        homePage
                .loadPage()
                .clickDatblesButtonSwitchToNewPage();
        dataTablesPage
                .dataTableAllExercise();



    }
}
