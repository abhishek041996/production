package Apis;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class organizationAPI {
	int statusCode1;

	 public static String organizationId;
	 public   int test() {

		Response response = given().when().header("Authorization",authorization.accessToken).get("https://emc-api.ddns.net/secure/Organization").then().extract().response();
		organizationId = response.thenReturn().jsonPath().getString("_id");
	    statusCode1 = response.thenReturn().statusCode();
//	     Serenity.recordReportData()
//         .withTitle("API Response")
//         .andContents(response.prettyPrint());
		 
		  System.out.println(statusCode1);
		return(statusCode1);
			}
}
