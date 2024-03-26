package apis.deanSave;

import apis.BaseUrl;
import apis.contactMessageSave.MessageSaveApi;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.ObjectMapperUtils;

import java.util.List;

import static io.restassured.RestAssured.given;

public class DeanSaveApi extends BaseUrl {
    Faker faker=new Faker();
    PayloadDeanSavePojo expectedData;
    Response response;
    public static String fakerPhoneNumber;
    private static String fakerSsn;

    public DeanSaveApi createPathParam(){
        spec.pathParams("1","dean","2","save");
        return this;
    }

    public DeanSaveApi createPayloadBody(){
        expectedData=new PayloadDeanSavePojo();
        expectedData.setName("Samet");
        expectedData.setSurname("Ozcelik");
        expectedData.setGender("MALE");
        expectedData.setBirthDay("1988-11-25");
        expectedData.setBirthPlace("yozgat");
        String fakerPhoneNumber=faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(100,999)+"-"+
        faker.number().numberBetween(1000,9999);
        expectedData.setPhoneNumber(fakerPhoneNumber);
         fakerSsn=faker.number().numberBetween(100,999)+"-"+faker.number().numberBetween(10,99)+"-"
                +faker.number().numberBetween(1000,9999);
        expectedData.setSsn(fakerSsn);
        String userName=faker.name().username()+"xyzlmk";
        expectedData.setUsername(userName);
        expectedData.setPassword("Ab142790.");

        return this;
    }

    public DeanSaveApi sendPayloadBodyGetResponseBody(){
        response= given(spec).body(expectedData).log().all().when().post("/{1}/{2}").
                then().log().all().extract().response();

        return this;
    }
    public static int userId;
    public DeanSaveApi assertionPostDeanSave(){
        //ResponseDeanSavePojo actualData=response.as(ResponseDeanSavePojo.class);
        Assert.assertEquals(response.statusCode(),200);
        ResponseDeanSavePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),ResponseDeanSavePojo.class);
        Assert.assertEquals(expectedData.getName(),actualData.getObject().getName());
        userId=actualData.getObject().getUserId();

        return this;
    }
    public DeanSaveApi olusturulanKayitinCagirilipDogrulanmasi(){
        //PathParam oluşturma
        spec.pathParams("1","dean","2","getManagerById","3",userId);

        //expectedData yok cünkü get işlemi

        //sendPayloadGetResponse
        Response response1= RestAssured.given().spec(spec).log().all().when().get("/{1}/{2}/{3}").then().log().all().extract().response();

        //Assertion
        ResponseDeanSavePojo actualData=response1.as(ResponseDeanSavePojo.class);
        Assert.assertEquals(response1.statusCode(),200);
        Assert.assertEquals(expectedData.getSsn(),actualData.getObject().getSsn());
        Assert.assertEquals(expectedData.getUsername(),actualData.getObject().getUsername());
        Assert.assertEquals(actualData.getMessage(),"Dean successfully found");

        return this;
    }
    public DeanSaveApi olusturulanKayidinsilinipDogrulanmasi(){
        //PathParam oluştur
        spec.pathParams("1","dean","2","delete",userId);

        //expectedData yok cünkü delete işlemi

        //send requset get response
        Response response2=given().spec(spec).log().all().when().delete("/{1}/{2}/{3}").then().log().all().extract().response();

        //Asertion
        Assert.assertEquals(response2.statusCode(),200);
        Assert.assertEquals(response2.jsonPath().getString("message"),"Dean Deleted");


        return this;

    }
}
