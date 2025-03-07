package Apis;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class getUnreadAlerts {

	static String id;
		 int statusCode1;
			public   int test() {

				Response response = given().when().header("Authorization",authorization.accessToken)
						.get("https://emc-api.ddns.net/secure/getUnreadAlerts/"+organizationAPI.organizationId).then().extract().response();
                          List<Object> list = response.then().extract().body().jsonPath().getList("_id");
                         System.out.println(list);
                         System.out.println(id);
                         if(list.isEmpty()){
                        	id=null;
                         }
                         else {
                        	id = list.get(0).toString();
                         }
                         statusCode1 = response.thenReturn().statusCode();
				         return(statusCode1);
					     }
	                     }


