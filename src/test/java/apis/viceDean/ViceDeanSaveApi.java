package apis.viceDean;

import apis.BaseUrl;
import apis.deanSave.DeanSaveApi;
import apis.deanSave.PayloadDeanSavePojo;
import apis.deanSave.ResponseDeanSavePojo;
import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;


public class ViceDeanSaveApi extends BaseUrl {
    public static PayloadViceDeanSavePojo expectedData;
    public static PayloadViceDeanSavePojo expectedPutData;
    Faker faker = new Faker();
    private static String fakerSsn;
    Response response;


    public ViceDeanSaveApi createPathParam() {
        Allure.step("Kullanıcı path param oluşturur.");
        spec.pathParams("1", "vicedean", "2", "save");
        return this;
    }

    public ViceDeanSaveApi createPayloadBody() {
        expectedPutData = new PayloadViceDeanSavePojo();
        expectedPutData.setName("Samet");
        expectedPutData.setSurname("Ozcelik");
        expectedPutData.setGender("MALE");
        expectedPutData.setBirthDay("1988-11-25");
        expectedPutData.setBirthPlace("yozgat");
        String fakerPhoneNumber = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(100, 999) + "-" +
                faker.number().numberBetween(1000, 9999);
        expectedPutData.setPhoneNumber(fakerPhoneNumber);
        fakerSsn = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-"
                + faker.number().numberBetween(1000, 9999);
        expectedPutData.setSsn(fakerSsn);
        String userName = faker.name().username() + "xyb";
        expectedPutData.setUsername(userName);
        expectedPutData.setPassword("Ab142790.");

        return this;
    }

    public ViceDeanSaveApi sendPayloadBodyGetResponseBody() {
        response = given(spec).body(expectedPutData).log().all().when().post("/{1}/{2}").
                then().log().all().extract().response();
        return this;
    }
    public static int userId;
    public ViceDeanSaveApi assertionPostViceDeanSave(){
        Allure.step("Kullanıcı doğrulama yapar.");
        ResponseDeanSavePojo actualData=response.as(ResponseDeanSavePojo.class);
        Assert.assertEquals(expectedPutData.getName(),actualData.getObject().getName());
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(actualData.getMessage(),"Vice dean Saved");
        userId=actualData.getObject().getUserId();
        return this;
    }
    public ViceDeanSaveApi olusturulanViceDeanPutIslemiVeDogrulama(){
        //PathParam oluştur
        spec.pathParams("1","vicedean","2","update","3",userId);

        //expectedData Olustur
        expectedData = new PayloadViceDeanSavePojo();
        expectedData.setName(faker.name().firstName());
        expectedData.setSurname("Ozcelik");
        expectedData.setGender("MALE");
        expectedData.setBirthDay("1988-11-25");
        expectedData.setBirthPlace("yozgat");
        String fakerPhoneNumber = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(100, 999) + "-" +
                faker.number().numberBetween(1000, 9999);
        expectedData.setPhoneNumber(fakerPhoneNumber);
        fakerSsn = faker.number().numberBetween(100, 999) + "-" + faker.number().numberBetween(10, 99) + "-"
                + faker.number().numberBetween(1000, 9999);
        expectedData.setSsn(fakerSsn);
        String userName = faker.name().username() + "xyb";
        expectedData.setUsername(userName);
        expectedData.setPassword("Ab142790.");

        //send payload get response
        Response response1=given().spec(spec).body(expectedPutData).log().all().when().put("/{1}/{2}/{3}").then().log().all().extract().response();

        //Asertion
        Assert.assertEquals(response1.statusCode(),200);


        return this;
    }
}
