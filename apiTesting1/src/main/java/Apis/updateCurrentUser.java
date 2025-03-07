package Apis;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class updateCurrentUser {
	int statusCode1;
	       public int test(String name) {
	    	   
	    	   Map<Object,String>data=new LinkedHashMap<Object,String>();
			   data.put("displayName",name);
			         Response response = given().when().header("Authorization",authorization.accessToken).body(data)
					.header("Content-Type","application/json")
					.post("https://emc-api.ddns.net/secure/updateCurrentUser").then().extract().response();
			
	        
		      statusCode1 = response.thenReturn().statusCode();
			  System.out.println(statusCode1);
			  return(statusCode1);
				}

	}


