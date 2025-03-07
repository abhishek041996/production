package Apis;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class getCurrentMonthBotConsumption {
	int statusCode1;
	public int test(String botId) {

	Response response = given().when().header("Authorization",authorization.accessToken)
			       .get("https://emc-api.ddns.net/secure/getCurrentMonthBotConsumption/"+botId)
			       .then().extract().response();
	            //  String responseString = response.prettyPrint();
                //System.out.println(responseString);
                
              statusCode1 = response.statusCode();
                       
	                    
	                    return(statusCode1);
		
}


}
