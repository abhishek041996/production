package Apis;

import static io.restassured.RestAssured.given;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class sendOtpAPI {
	public int test(String emailId) {
		int statusCode1;
		Map<Object,String>data=new LinkedHashMap<Object,String>();
		data.put("email", emailId);
		
				                Response response = given().when().body(data)
						       .header("Content-Type","application/json")
						       .post("https://emc-api.ddns.net/sendOTP")
						       .then().extract().response();
				                   
			                    statusCode1 = response.thenReturn().statusCode();
				                System.out.println(statusCode1);
				                return(statusCode1);
	}		
}
