package tests.ui.api;

import org.testng.annotations.Test;

public class TestPostContactMessageSave extends BaseTestApi{
    @Test
    public void testMessage() {
        messageSaveApi
                .createPathParam()
                .createPayloadBody()
                .sendPayloadAndGetResponse()
                .assertionMessageSaveApi();


    }
}
