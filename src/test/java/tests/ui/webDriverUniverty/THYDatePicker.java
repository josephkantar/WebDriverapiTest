package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;

import static utils.BrowserUtils.waitFor;

public class THYDatePicker extends BaseTest{
    @Test
    public void testDateThy() {
       datePage.
               loadPage().verifyDateTodayAndSelectedEnabledDisabled()
               .verifyDateYesterdayAndSelectedEnabledDisabled()
               .verifyDateTomorrowAndSelectedEnabledDisabled();

    }
}
