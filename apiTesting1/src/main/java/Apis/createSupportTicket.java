package Apis;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class createSupportTicket {
	int statusCode1;
	public   int test() {
		Map<Object,String>data=new LinkedHashMap<Object,String>();
		data.put("orgId", "6576abe29a5c3249ba7a0764");
		data.put("botId", "1414");
		data.put("email", "ashish.taldeokar@sustlabs.com");
		data.put("name", "atul");
		data.put("number", "918888888888");
		data.put("issueType", "general");
		data.put("subIssueType", "others");
		data.put("description", "testing");
		Response response = given().when().header("Content-Type","application/json").header("Authorization",authorization.accessToken).body(data)
				            .post("https://emc-api.ddns.net/secure/createSupportTicket").then().extract().response();
		
//		 System.out.println(response.prettyPrint());
//		 Serenity.recordReportData()
//       .withTitle("API Response")
//       .andContents(response.prettyPrint());
	     statusCode1 = response.thenReturn().statusCode();
          
		 System.out.println(statusCode1);
		 return(statusCode1);
			}

}
