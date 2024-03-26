package apis.contactMessageSave;

import apis.BaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class MessageSaveApi extends BaseUrl {
    PayloadMessageSave expectedData;
    Response response;

    public MessageSaveApi createPathParam(){
        spec.pathParams("1","contactMessages","2","save");
        return this;
    }

    public MessageSaveApi createPayloadBody(){
    expectedData=new PayloadMessageSave();
    expectedData.setName("Serseri");
    expectedData.setEmail("samet@mail7.io");
    expectedData.setMessage("daha iyi bir site yapın");
    expectedData.setSubject("java");

        return this;
    }
    public MessageSaveApi sendPayloadAndGetResponse(){
    response=given().spec(spec).body(expectedData).log().all().when().post("/{1}/{2}").then().log().all().extract().response();
        return this;
    }
    public MessageSaveApi assertionMessageSaveApi(){
        ResponseMessageSave actualData=response.as(ResponseMessageSave.class);
        Assert.assertEquals(expectedData.getName(),actualData.getObject().getName());
        return this;
    }

}
