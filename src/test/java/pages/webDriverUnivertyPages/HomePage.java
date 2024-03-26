package pages.webDriverUnivertyPages;


import driver.DriverMngr;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static constants.FrameworkConstants.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='CONTACT US']")
    private WebElement contactUs;
    @FindBy(xpath = "//*[text()='LOGIN PORTAL']")
    private WebElement loginPortal;
    @FindBy(xpath = "//*[text()='BUTTON CLICKS']")
    private WebElement buttonClick;
    @FindBy(xpath = "//*[text()='DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)']")
    private WebElement dropDown;
    @FindBy(xpath = "//*[text()='ACTIONS']")
    private WebElement buttonActions;
    @FindBy(xpath = "//*[text()='DATA, TABLES & BUTTON STATES']")
    private WebElement dataTables;
    @FindBy(xpath = "//*[text()='IFRAME']")
    private WebElement buttonIframe;
    @FindBy(xpath = "//*[text()='POPUP & ALERTS']")
    private WebElement buttonPopupAlerts;
    @FindBy(xpath = "//*[text()='FILE UPLOAD']")
    private WebElement buttonFileUpload;
    @FindBy(xpath = "//*[text()='DATA, TABLES & BUTTON STATES']") private WebElement buttonDataTableButton;


    public HomePage loadPage() {

        navigateTo_URL(getHomepageUrl());
        return this;
    }

    public ConstactUsPage clickContactUsButtonSwichToNewPage() {

        String homeWindow = DriverMngr.getDriver().getWindowHandle();
        click(contactUs);
        switchToNewWindow(homeWindow);
        return new ConstactUsPage(driver);
    }

    public LoginPortalPage clickLoginPortalButtonToNewPage() {
        String homeWindow = DriverMngr.getDriver().getWindowHandle();
        click(loginPortal);
        switchToNewWindow(homeWindow);
        return new LoginPortalPage(driver);
    }

    public ButtonClickPage clickButtonClickSwitchToNewPage() {
        String homeWindow = DriverMngr.getDriver().getWindowHandle();
        click(buttonClick);
        switchToNewWindow(homeWindow);

        return new ButtonClickPage(driver);
    }

    public DropDownPage clickDropDownSwitchToNewPage() {
        String homeWindow = DriverMngr.getDriver().getWindowHandle();
        click(dropDown);
        switchToNewWindow(homeWindow);

        return new DropDownPage(driver);
    }

    public ActionsPage clickActionsButtonSwitchToNewPage() {
        Allure.step("Kullanıcı actions butonuna tıklar.");
        String homeWindow = DriverMngr.getDriver().getWindowHandle();
        click(buttonActions);
        switchToNewWindow(homeWindow);
        return new ActionsPage(driver);
    }

    public DataTablesPage clickDatblesButtonSwitchToNewPage() {
        Allure.step("Kullanıcı actions butonuna tıklar.");
        String homeWindow = DriverMngr.getDriver().getWindowHandle();
        click(dataTables);
        switchToNewWindow(homeWindow);
        return new DataTablesPage(driver);
    }

    public IframePage clickIframeButtonSwitchToNewPage() {
        Allure.step("Kullanıcı iframe butonuna tıklar.");
        String homeWindow = DriverMngr.getDriver().getWindowHandle();
        click(buttonIframe);
        switchToNewWindow(homeWindow);
        return new IframePage(driver);
    }

    public PopupAlertsPage clickPopupAlertsButtonSwitchToNewPage() {
        Allure.step("Kullanıcı popup alerts butonuna tıklar.");
        String homeWindow = DriverMngr.getDriver().getWindowHandle();
        click(buttonPopupAlerts);
        switchToNewWindow(homeWindow);
        return new PopupAlertsPage(driver);

    }

    public FileUploadNewPage clickFileUploadButtonSwitchToNewPage() {
        Allure.step("Kullanıcı popup alerts butonuna tıklar.");
        String homeWindow = DriverMngr.getDriver().getWindowHandle();
        click(buttonFileUpload);
        switchToNewWindow(homeWindow);
        return new FileUploadNewPage(driver);
    }
    public DataTableButtonPage clickDataTableButtonSwitchToNewPage() {
        Allure.step("Kullanıcı popup alerts butonuna tıklar.");
        String homeWindow = DriverMngr.getDriver().getWindowHandle();
        click(buttonDataTableButton);
        switchToNewWindow(homeWindow);
        return new DataTableButtonPage(driver);
    }

}