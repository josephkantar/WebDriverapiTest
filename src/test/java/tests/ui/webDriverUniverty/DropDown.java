package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;

public class DropDown extends BaseTest{
    @Test
    public void testDropDown() {
        homePage
                .loadPage()
                .clickDropDownSwitchToNewPage();
        dropDownPage
                .selectPyhtonFromDropDownMenu1()
                .selectTestNGFromDropDownMenu2()
                .selectCSSFromDropDownMenu3()
                .selectRadioButtonBlue()
                .verifyCabbageDisabled();
    }
}
