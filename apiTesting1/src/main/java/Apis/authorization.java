package Apis;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;


public class authorization {

	   public static String accessToken;		
	   int statusCode;
       public  int test() {
			Map<Object,String>data=new LinkedHashMap<Object,String>();     
			data.put("grant_type", "refresh_token");
			data.put("refresh_token",loginAPI.refreshToken);
			Response response = given().header("Content-Type","application/json")
					            .body(data).when()
					            .post("https://securetoken.googleapis.com/v1/token?key=AIzaSyA9EZfAKTfaYP08GGZl1ntCF-q4qstmpCI")
				            	.then().extract().response();
			accessToken = response.thenReturn().jsonPath().getString("access_token");
			statusCode= response.thenReturn().statusCode();
	        return(statusCode);
	     
    }
}