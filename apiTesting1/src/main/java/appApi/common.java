package appApi;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.response.Response;

public class common {
	int statusCode;

	public void getAccountDetails() {
		Response response = given().when().header("Authorization", token.tokenValue)
				.get("https://api.sustlabs.com/secure/getCurrentUser").then().extract().response();
		statusCode = response.thenReturn().statusCode();

	}

	public void val(int statuscode) {
		assertEquals(statuscode, this.statusCode);
	}

	public void applianceUsageAPI() {
		Response response = given().when().header("Authorization", token.tokenValue)
				.get("https://api.sustlabs.com/secure/getApplianceUsageLogs/2330?page=0&count=100").then().extract()
				.response();
		statusCode = response.thenReturn().statusCode();

	}

	public void getEnergyConsumptionAPI() {
		Response response = given().when().header("Authorization", token.tokenValue)
				.get("https://api.sustlabs.com/secure/getEnergyConsumptionMonth/2330?startTime=112023&endTime=112023")
				.then().extract().response();
		statusCode = response.thenReturn().statusCode();

	}

	public void getDetailsAPI() {
		Response response = given().when().header("Authorization", token.tokenValue)
				.get("https://api.sustlabs.com/secure/getBotInfo/2330").then().extract().response();
		statusCode = response.thenReturn().statusCode();

	}

	public void getDaywiseConsumptionAPI() {
		Response response = given().when().header("Authorization", token.tokenValue).get(
				"https://api.sustlabs.com/secure/getDayWiseEnergyConsumption/2330?startTime=2023-07-31T18:30:00.000Z&endTime=2023-08-29T18:30:00.000Z")
				.then().extract().response();
		statusCode = response.thenReturn().statusCode();
	}
	public void gatDaywiseAPI() {
		Response response = given().when().header("Authorization", token.tokenValue).get(
				"https://api.sustlabs.com/secure/getDayWiseUptime/2330?startTime=2023-09-12T18:30:00.000Z&endTime=2023-09-17T18:29:59.999Z")
				.then().extract().response();
		statusCode = response.thenReturn().statusCode();
	}
	public void getTotalAppliancesAPI() {
		Response response = given().when().header("Autho rization", token.tokenValue)
				.get("https://api.sustlabs.com/secure/fetchApplianceCountsByMeterId/2330").then().extract().response();
		statusCode = response.thenReturn().statusCode();
	}
	public void getServiceHistoryAPI() {
		Response response = given().when().header("Authorization", token.tokenValue)
				.get("https://api.sustlabs.com/secure/getServiceHistory/2330/623af2c0663b2aab1dadc65e").then().extract()
				.response();
		statusCode = response.thenReturn().statusCode();
	}
	public void gatApplianceUsageForDayAPI() {
		Response response = given().when().header("Authorization", token.tokenValue).get(
				"https://api.sustlabs.com/secure/getBreakDownv2/2330?start=2023-07-12T18:30:00.000Z&end=2023-08-13T18:30:00.000Z")
				.then().extract().response();
		statusCode = response.thenReturn().statusCode();
	}

	public void getTotalUtilitiesAPI() {
		Response response = given().when().header("Authorization", token.tokenValue)
				.get("https://api.sustlabs.com/secure/getStateWiseUtility").then().extract().response();
		statusCode = response.thenReturn().statusCode();
	}

	public void getSubscriptionPlansAPI() {
		Response response = given().when().header("Authorization", token.tokenValue)
				.get("https://api.sustlabs.com/secure/fetchPlans").then().extract().response();
		statusCode = response.thenReturn().statusCode();
	}

	public void getCurrentSubscriptionAPI() {
		Response response = given().when()
				.header("Authorization", token.tokenValue)
				
				.get("https://api.sustlabs.com/secure/currentSubscription/3102").then().extract().response();
		statusCode = response.thenReturn().statusCode();
	}

	public void getStatement() {
		Response response = given().when()
				.header("Authorization", token.tokenValue)
				.get("https://api.sustlabs.com/secure/requestStatement/1308?from=1/12/2023&upto=25/12/2023&to=abhishek.amilkantwar@sustlabs.com").then().extract().response();
		statusCode = response.thenReturn().statusCode();
		
	}

	public void update() {
		Map<String,Object>data=new LinkedHashMap<>();
		data.put("billingDate", 20);
		data.put("consumerId", 123456789);
		 Response response = given().header("Authorization", token.tokenValue).header("Content-Type","application/json")
				.body(data).when().put("https://api.sustlabs.com/secure/updateBotInfo/2330").then().extract().response();
		 statusCode = response.thenReturn().statusCode();
	}

	public void updateDetails() {
		Map<String,Object>data=new LinkedHashMap<>();
		data.put("displayName", "abhishek");
		Response response = given().header("Authorization", token.tokenValue).header("Content-Type","application/json")
				.body(data).when().put("https://api.sustlabs.com/secure/updateUser").then().extract().response();
		 statusCode = response.thenReturn().statusCode();
	}
		
	}

