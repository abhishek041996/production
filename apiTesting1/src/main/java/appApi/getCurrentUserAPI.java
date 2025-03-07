package appApi;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class getCurrentUserAPI {
	String mobileNumber;
	String accountName;
	String activeStatus;
	String emailId;
	String accountCreationDate;
	int statusCode1;
	@Step("get the details of the user")
	public void getDetails() {
	Response response = given().when().header("Authorization",token.tokenValue).get("https://api.sustlabs.com/secure/getCurrentUser").then().extract().response();
	 System.out.println(response);
	 mobileNumber = response.thenReturn().jsonPath().getString("mobile");
     accountName = response.thenReturn().jsonPath().getString("displayName");
     activeStatus = response.thenReturn().jsonPath().getString("isActive");
     emailId = response.thenReturn().jsonPath().getString("email");
     accountCreationDate = response.thenReturn().jsonPath().getString("createdat");
     statusCode1 = response.thenReturn().statusCode();
    }
	
public void verifyStatusCode(int statusCode) {
	
	
	
	
	assertEquals(statusCode,statusCode1);
		
	}

public void validate(String mobileNumber1, String accountName1, String activeStatus1, String emailId1, String accountCreationDate1) {
	assertEquals(mobileNumber1,mobileNumber);
	assertEquals(accountName1,accountName);
	assertEquals(activeStatus1,activeStatus);
	assertEquals(emailId1,emailId);
	assertEquals(accountCreationDate1,accountCreationDate);
	
}

public void validateUpdatedDetails(String name, String emailId2) {
	getDetails();
	assertEquals(name,accountName);
	assertEquals(emailId2,emailId);
	
}


}