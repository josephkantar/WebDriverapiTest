package tests.ui.webDriverUniverty;

import org.testng.annotations.Test;

import static constants.FrameworkConstants.getPassword;
import static constants.FrameworkConstants.getUserName;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginPortal extends BaseTest{
    @Test
    public void testLoginPortal() {

        homePage
                .loadPage()
                .clickLoginPortalButtonToNewPage();
        loginPortalPage
                .enterUserName(getUserName())
                .enterPassword(getPassword())
                .clickLoginButton()
                .veriyfAllertMessage();

    }

}
