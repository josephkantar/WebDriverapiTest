package tests.api.herokuapp;


import apis.herokuapp.HerokuApp;
import org.testng.annotations.Test;


public class HerokuAppApi {
    HerokuApp herokuApp=new HerokuApp();

    @Test
    public void test1(){
        herokuApp
                .kullaniciExpectedDataOlusturur()
                .kullaniciSendRequestGetResponse()
                .kullaniciPostMetodununDogrulamasiniYapar()
                .kullaniciLoginGerceklestirirTokenAlir()
                .kullaniciOlusturduguKaydiSilerVeDogrular();

    }

}