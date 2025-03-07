package Apis;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class getCurrentUser {
	 int statusCode1;
	public   int test() {

		Response response = given().when().header("Authorization",authorization.accessToken)
				           .get("https://emc-api.ddns.net/secure/getCurrentUser").then().extract().response();
		
		// System.out.println(response.prettyPrint());
	     statusCode1 = response.thenReturn().statusCode();
	    // Serenity.recordReportData()
        // .withTitle("API Response")
         //.andContents(response.prettyPrint());
          
		System.out.println(statusCode1);
		return(statusCode1);
			}

}
