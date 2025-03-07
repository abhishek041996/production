package Apis;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class topConsumers {
	int statusCode1;

	public int test() {
		Response response = given().when().header("Authorization",authorization.accessToken)
				.get("https://emc-api.ddns.net/secure/topConsumers/"+organizationAPI.organizationId)
				.then().extract().response();
			           statusCode1 = response.thenReturn().statusCode();
			           //System.out.println(response.prettyPrint());
			           System.out.println(statusCode1);
				       return statusCode1;
				}
		
	}


