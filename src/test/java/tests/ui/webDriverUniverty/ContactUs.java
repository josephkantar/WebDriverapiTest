package tests.ui.webDriverUniverty;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import static constants.FrameworkConstants.*;

public class ContactUs extends BaseTest {
    @Severity(SeverityLevel.CRITICAL)
    @Step("Kullanıcı mesaj gönderebilmeli")
    @Test(testName = "Mesaj gönderme pozitif test",retryAnalyzer = RetryAnalyzer.class)
    public void testContactUs() {

        homePage
                .loadPage()
                .clickContactUsButtonSwichToNewPage();
        constactUsPage
                .enterFirstName(getFirstName())
                .enterLastName(getLastName())
                .enterEmail()
                .enterMessage()
                .clickSubmitButton()
                .verifyThankYouForYourMessage();
    }
}
