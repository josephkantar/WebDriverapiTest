package apis;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.Authentication;

public class BaseUrl extends Authentication {
    public static RequestSpecification  spec;

    public static void setupApi(){
        spec=new RequestSpecBuilder()
                .setBaseUri("https://managementonschools.com/app") //adres swaggerdeki başlangec endpoint olacak
                .addHeader("Authorization", generateToken())
                .setContentType(ContentType.JSON)
         .build();



    }
}
