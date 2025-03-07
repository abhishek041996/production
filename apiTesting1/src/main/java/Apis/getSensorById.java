package Apis;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class getSensorById {
	int statusCode1;
	public   int test(String botId) {
     
		Response response = given().when().header("Authorization",authorization.accessToken).header("orgId",organizationAPI.organizationId)
				.get("https://emc-api.ddns.net/secure/getSensorById/"+botId).then().extract().response();
		
//		 System.out.println(response.prettyPrint());
//		 Serenity.recordReportData()
//         .withTitle("API Response")
//         .andContents(response.prettyPrint());
	     statusCode1 = response.thenReturn().statusCode();
          
		System.out.println(statusCode1);
		return(statusCode1);
			}

}
