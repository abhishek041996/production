package Apis;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class updateSensorById {

	int statusCode1;
	public   int test(String nickName,String botId) {
		 Map<Object,String>data=new LinkedHashMap<Object,String>();
			data.put("nickName",nickName);
		Response response = given().when().header("Authorization",authorization.accessToken).header("orgId",organizationAPI.organizationId).header("Content-Type","application/json").body(data)
				.put("https://emc-api.ddns.net/secure/updateSensorById/"+botId).then().extract().response();
		       // System.out.println(response.prettyPrint());
	            statusCode1 = response.thenReturn().statusCode();
                String newNickName=response.thenReturn().jsonPath().getString("data.nickName");
        		assertEquals(nickName, newNickName);
//        		Serenity.recordReportData()
//                .withTitle("API Response")
//                .andContents(response.prettyPrint());
		        System.out.println(statusCode1);
		        return(statusCode1);
			}

}
 