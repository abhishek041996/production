package Apis;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class daywiseBotData {
	int statusCode1;
	public int test(String botId,String startDate, String endDate ) {
	Response response = given().when().header("Authorization",authorization.accessToken)
	.get("https://emc-api.ddns.net/secure/daywiseBotData/"+botId+"?startDate="+startDate+"&endDate="+endDate)
	.then().extract().response();
	      // System.out.println(response.prettyPrint());
//	       Serenity.recordReportData()
//         .withTitle("API Response")
//         .andContents(response.prettyPrint());
           statusCode1 = response.thenReturn().statusCode();
           System.out.println(statusCode1);
	       return statusCode1;
	}

}
