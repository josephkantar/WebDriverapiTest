package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {
//    public static void main(String[] args) {
//        String guncelToken=generateToken();
//        System.out.println("guncelToken = " + guncelToken);
//    }
    public static String generateToken(){  // bu gösterim string hali
        String body = "{\n" +
                "  \"password\": \"Gurkay123+\",\n" +
                "  \"username\": \"AdminGurkay\"\n" +
                "}";
        Response response = given().body(body).contentType(ContentType.JSON).when().post("https://managementonschools.com/app/auth/login");
        return response.jsonPath().getString("token");
    }

}
