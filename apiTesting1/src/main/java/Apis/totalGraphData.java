package Apis;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class totalGraphData {

	public int test(String param1, String timeFilter1) {
	int statusCode1;
     
	         Map<Object,String>data=new LinkedHashMap<Object,String>();
	        
			data.put("orgId",organizationAPI.organizationId );
			data.put("param", param1);
			data.put("timeFilter",timeFilter1);
			

			Response response = given().when().header("Authorization",authorization.accessToken)
					            .header("Content-Type","application/json")
					            .body(data).post("https://emc-api.ddns.net/secure/totalGraphData")
					            .then().extract().response();
			//System.out.println(response.prettyPrint());
//			Serenity.recordReportData()
//            .withTitle("API Response")
//            .andContents(response.prettyPrint());
		                        statusCode1 = response.thenReturn().statusCode();
			                    System.out.println(statusCode1);
			                    return(statusCode1);
				}

	

		
		
	}


