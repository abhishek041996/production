package appApi;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
public class energyConsumptionAPI {
	
	
	public  void getConsumption(String botId) {
		
		
		Response response = given().when().header("Authorization",token.tokenValue).get("https://api.sustlabs.com/secure/getEnergyConsumption/"+botId+"?startTime=01/01/2023&endTime=31/01/2023").then().extract().response();
	    String totalConsumption = response.thenReturn().jsonPath().getString("totalEC");
	    Serenity.recordReportData()
        .withTitle("API Response")
        .andContents(response.prettyPrint());
	    System.out.println(totalConsumption);
			}
}
