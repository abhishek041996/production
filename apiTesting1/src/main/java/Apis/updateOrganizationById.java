package Apis;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class updateOrganizationById {
	int statusCode1;

	public int test(String city, String name) {
	    	   
	    	   Map<Object,String>data=new LinkedHashMap<Object,String>();
				data.put("city",city);
			Response response = given().when().header("Authorization",authorization.accessToken).body(data)
				               	.header("Content-Type","application/json")
					            .put("https://emc-api.ddns.net/secure/Organization/"+organizationAPI.organizationId).then().extract().response();
//			
//			 System.out.println(response.prettyPrint());
//			 Serenity.recordReportData()
//           .withTitle("API Response")
//           .andContents(response.prettyPrint());
		     statusCode1 = response.thenReturn().statusCode();
			 System.out.println(statusCode1);
			 return(statusCode1);
				}

}
