package Apis;


import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;


public class markAlertStatus {


	 int statusCode1;
		public   int test() {
			if(getUnreadAlerts.id!=null) {
			 Map<String,Object>data=new LinkedHashMap<String,Object>();
				data.put("alertIds",new String[]{getUnreadAlerts.id});

			Response response = given().when().header("Authorization",authorization.accessToken).header("Content-Type","application/json").body(data)
					.put("https://emc-api.ddns.net/secure/markAlertStatus/"+organizationAPI.organizationId).then().extract().response();
			       //System.out.println(response.prettyPrint());
		            statusCode1 = response.thenReturn().statusCode();
		           // Serenity.recordReportData()
//                    .withTitle("API Response")
//                    .andContents(response.prettyPrint());
			System.out.println(statusCode1);
			return(statusCode1);
			}
			else {
				return(200);
			}
			}
				}


