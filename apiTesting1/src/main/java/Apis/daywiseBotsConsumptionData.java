package Apis;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class daywiseBotsConsumptionData {

	public int test(String date1, String date2) {
		int statusCode1;
		Response response = given().when().header("Authorization",authorization.accessToken)
				       .get("https://emc-api.ddns.net/secure/daywiseBotsConsumptionData/"+organizationAPI.organizationId+"?start="+date1+"&end="+date2)
				       .then().extract().response();
				       // System.out.println(response.prettyPrint());
//				        Serenity.recordReportData()
//                      .withTitle("API Response")
//                      .andContents(response.prettyPrint());
			            statusCode1 = response.thenReturn().statusCode();
			            System.out.println(statusCode1);

		return statusCode1;
	}

}
