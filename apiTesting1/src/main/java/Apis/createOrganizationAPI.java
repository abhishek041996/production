package Apis;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class createOrganizationAPI {
	 int statusCode1;
		public   int test(String companyName, String gstNumber) throws JsonProcessingException {
			    Map<Object,String>data=new LinkedHashMap<Object,String>();
				data.put("name",companyName);
				data.put("gstNumber",gstNumber);
				authorization token=new authorization(); 
				loginAPI login=new loginAPI();
				login.test("abhiamilkanthwar96@gmail.com", "India@12345");
		        token.test();
			    Response response = given().when().header("Authorization",authorization.accessToken)
			    		            .header("Content-Type","application/json").body(data)
					                .post("https://emc-api.ddns.net/secure/createOrganization").then()
					                .extract().response();
			
//			System.out.println(response.prettyPrint());
//			Serenity.recordReportData()
//          .withTitle("API Response")
//          .andContents(response.prettyPrint());
            statusCode1 = response.thenReturn().statusCode();
         
	        System.out.println(statusCode1);
	        return(statusCode1);
				}
}
