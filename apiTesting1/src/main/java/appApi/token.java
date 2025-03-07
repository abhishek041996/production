package appApi;

import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;
import java.util.Map;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class token {
	public static String tokenValue;
	public  void test() {
		Map<Object,String>data=new LinkedHashMap<Object,String>();
		data.put("grant_type", "refresh_token");
		data.put("refresh_token", "AOkPPWRlOnxK0myl80_qiC9jKQEEUNm2VT4WC8FzdUhWJaPHoF4waWswdYa0z3vpb_u9sBvR5B9T3xXgwqVgw115C6wUQ7HCCEV1bgiooIXGlsnuZtkC_T6SIeYPn5u-Q3dm4hV29YlA4L6cH0JajqmHXWEEI_kFl79bfuCcZvAB05VYtFGBSyxme1T8jpToWdfB2_1W_TxU");
		Response response = given().when().body(data).post("https://securetoken.googleapis.com/v1/token?key=AIzaSyBmtOp_PY0TowU_0P_r4cI2e--gSo2CyVA").then().extract().response();
	    tokenValue = response.thenReturn().jsonPath().getString("access_token");
	    Serenity.recordReportData()
        .withTitle("API Response")
        .andContents(response.prettyPrint());
		System.out.println(tokenValue);
			}
	}
