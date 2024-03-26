package tests.ui.webDriverUniverty;

import driver.DriverMngr;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.automationExercisePages.FileDownLoadPage;
import pages.thyPages.DatePage;
import pages.webDriverUnivertyPages.*;

import static driver.Driver.initDriver;
import static driver.Driver.quitDriver;

public class BaseTest {
    HomePage homePage;
    ConstactUsPage constactUsPage;
    LoginPortalPage loginPortalPage;
    ButtonClickPage buttonClickPage;
    DropDownPage dropDownPage;
    ActionsPage actionsPage;
    DataTablesPage dataTablesPage;
    IframePage iframePage;
    PopupAlertsPage popupAlertsPage;
    DatePage datePage;
    FileDownLoadPage fileDownLoadPage;
    FileUploadNewPage fileUploadNewPage;
    DataTableButtonPage dataTableButtonPage;
    LambdaTestPage lambdaTestPage;
    LambdaTestPage2 lambdaTestPage2;

    @BeforeMethod
    public void setup(){
        initDriver();
        homePage=new HomePage(DriverMngr.getDriver());
        constactUsPage=new ConstactUsPage(DriverMngr.getDriver());
        loginPortalPage=new LoginPortalPage(DriverMngr.getDriver());
        buttonClickPage=new ButtonClickPage(DriverMngr.getDriver());
        dropDownPage=new DropDownPage(DriverMngr.getDriver());
        actionsPage=new ActionsPage(DriverMngr.getDriver());
        dataTablesPage=new DataTablesPage(DriverMngr.getDriver());
        iframePage=new IframePage(DriverMngr.getDriver());
        popupAlertsPage=new PopupAlertsPage(DriverMngr.getDriver());
        datePage=new DatePage(DriverMngr.getDriver());
        fileDownLoadPage=new FileDownLoadPage(DriverMngr.getDriver());
        fileUploadNewPage=new FileUploadNewPage(DriverMngr.getDriver());
        dataTableButtonPage=new DataTableButtonPage(DriverMngr.getDriver());
        lambdaTestPage=new LambdaTestPage(DriverMngr.getDriver());
        lambdaTestPage2=new LambdaTestPage2(DriverMngr.getDriver());
        
    }

    @AfterMethod
    public void tearDown(){
        quitDriver();
    }
}
