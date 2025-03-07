package Apis;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class botGraphData {

	public int test(String param1, String timeFilter1) {
		int statusCode1;

				Response response = given().when().header("Authorization",authorization.accessToken)
						       .header("Content-Type","application/json")
						       .get("https://emc-api.ddns.net/secure/botGraphData/5696?param="+param1+"&timeFilter="+timeFilter1)
						       .then().extract().response();
				//System.out.println(response.prettyPrint());
//				Serenity.recordReportData()
//                .withTitle("API Response")
//                .andContents(response.prettyPrint());
			                        statusCode1 = response.thenReturn().statusCode();
				                    System.out.println(statusCode1);
				                    return(statusCode1);
					
	}

}
