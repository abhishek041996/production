package appApi;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;


import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
public class updateUserDataAPI {
	String newAccountName;
	String newEmailId1;
	int statusCode1;
public  void update(String name,String emailId) {
	System.out.println(name);
	System.out.println(emailId);
	Map<Object,String>updateData=new LinkedHashMap<Object,String>();
	updateData.put("displayName", name);
	updateData.put("email", emailId);
	
	Response response = given().header("Authorization",token.tokenValue).header("Content-Type","application/json").body(updateData).when().put("https://api.sustlabs.com/secure/updateUser").then().extract().response();
	
	newAccountName = response.thenReturn().jsonPath().getString("displayName");
    newEmailId1 = response.thenReturn().jsonPath().getString("email");
    statusCode1 = response.thenReturn().statusCode();
    Serenity.recordReportData()
    .withTitle("API Response")
    .andContents(response.prettyPrint());

}
public void validateStatusCode(int StatusCode) {
	assertEquals(StatusCode,statusCode1);
	}
public void validateDataResponse(String newName, String newEmailId) {
	assertEquals(newName,newAccountName);
	assertEquals(newEmailId,newEmailId1);
	
}
}
