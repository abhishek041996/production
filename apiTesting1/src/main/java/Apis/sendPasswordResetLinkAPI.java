package Apis;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class sendPasswordResetLinkAPI {
	public int test(String emailId) {
		int statusCode1;
		
		Map<Object,String>data=new LinkedHashMap<Object,String>();
		data.put("email", emailId);
		data.put("url", "https://sustlabs-emc.web.app/reset-password");
				Response response = given().when().body(data)
						       .header("Content-Type","application/json")
						       .post("https://emc-api.ddns.net/sendPasswordResetLink")
						       .then().extract().response();
//				Serenity.recordReportData()
//                .withTitle("API Response")
//                .andContents(response.prettyPrint());
//				                System.out.println(response.prettyPrint());
			                    statusCode1 = response.thenReturn().statusCode();
				                System.out.println(statusCode1);
				                 return(statusCode1);
	}	

}
