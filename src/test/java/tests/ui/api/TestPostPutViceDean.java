package tests.ui.api;

import org.testng.annotations.Test;

public class TestPostPutViceDean extends BaseTestApi{
    @Test
    public void testPostPutViceDean() {
            viceDeanSaveApi
                    .createPathParam()
                    .createPayloadBody()
                    .sendPayloadBodyGetResponseBody()
                    .assertionPostViceDeanSave()
                    .olusturulanViceDeanPutIslemiVeDogrulama();
    }
}
