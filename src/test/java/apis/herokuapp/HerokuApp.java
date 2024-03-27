package apis.herokuapp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class HerokuApp {
    Response response;
    public static PayloadPojo expectedData;
    int bookingid;
    String token;

    public HerokuApp kullaniciExpectedDataOlusturur(){
        expectedData=new PayloadPojo();
        PayloadBookingdatesPojo bookingdatesPojo = new PayloadBookingdatesPojo();

        expectedData.setFirstname("Mesut");
        expectedData.setLastname("Mergen");
        expectedData.setTotalprice(111);
        expectedData.setDepositpaid(true);
        expectedData.setAdditionalneeds("Breakfast");
        bookingdatesPojo.setCheckin("2024-03-03");
        bookingdatesPojo.setCheckout("2024-03-05");
        expectedData.setBookingdates(bookingdatesPojo);

        return this;

    }
    public HerokuApp kullaniciSendRequestGetResponse(){
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(expectedData)
                .log().all()
                .when().post("https://restful-booker.herokuapp.com/booking")
                .then().log().all().extract().response();
        return this;
    }
    public HerokuApp kullaniciPostMetodununDogrulamasiniYapar(){
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(jsonPath.getString("booking.firstname"),expectedData.getFirstname());
        bookingid=jsonPath.getInt("bookingid");
        return this;
    }
    public HerokuApp kullaniciLoginGerceklestirirTokenAlir(){
        Map<String,String>loginExpectedData=new HashMap<>();
        loginExpectedData.put("username","admin");
        loginExpectedData.put("password","password123");
        Response loginResponse=RestAssured.given()
                .header("Content-Type", "application/json")
                .body(loginExpectedData)
                .log().all()
                .when().post("https://restful-booker.herokuapp.com/auth")
                .then().log().all().extract().response();

        Map<String,String>actualDataLogin=loginResponse.as(HashMap.class);
        Assert.assertEquals(loginResponse.statusCode(),200);
        token=actualDataLogin.get("token");
        Assert.assertTrue(!token.isEmpty());
        return this;
    }
    public HerokuApp kullaniciOlusturduguKaydiSilerVeDogrular(){
        response=RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token="+token)
                .log().all()
                .when().delete("https://restful-booker.herokuapp.com/booking/"+bookingid)
                .then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(),201);

        return  this;
    }

}

//note
