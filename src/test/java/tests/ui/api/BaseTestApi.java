package tests.ui.api;

import apis.contactMessageSave.MessageSaveApi;
import apis.deanSave.DeanSaveApi;
import apis.viceDean.ViceDeanSaveApi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static apis.BaseUrl.setupApi;

public class BaseTestApi {

    DeanSaveApi deanSaveApi;
    MessageSaveApi messageSaveApi;
    ViceDeanSaveApi viceDeanSaveApi;
    @BeforeMethod
    public void setup(){
        setupApi();
        deanSaveApi=new DeanSaveApi();
        messageSaveApi=new MessageSaveApi();
        viceDeanSaveApi=new ViceDeanSaveApi();


    }
    @AfterMethod
    public  void tearDown(){


    }
}
