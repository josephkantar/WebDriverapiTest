package tests.ui.api;

import org.testng.annotations.Test;

public class TestPostGetDeleteDeanSave extends BaseTestApi{

    @Test
    public void testDeanSave() {
        deanSaveApi
                .createPathParam()
                .createPayloadBody()
                .sendPayloadBodyGetResponseBody()
                .assertionPostDeanSave()
                .olusturulanKayitinCagirilipDogrulanmasi()
                .olusturulanKayidinsilinipDogrulanmasi();

    }
}
