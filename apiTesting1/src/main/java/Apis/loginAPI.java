package Apis;


import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
	import org.apache.http.client.methods.HttpPost;
	import org.apache.http.entity.StringEntity;
	import org.apache.http.impl.client.CloseableHttpClient;
	import org.apache.http.impl.client.HttpClients;
	import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

	public class loginAPI {
		int statusCode;
		 public static String refreshToken;
	    public int test(String username, String password) throws JsonProcessingException {
	    	
            String url = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyA9EZfAKTfaYP08GGZl1ntCF-q4qstmpCI";

	    	  Map<String, Object> data = new HashMap<>();
	    	  data.put("email",username);
	    	  data.put("password",password);
	    	  data.put("returnSecureToken",true); 
	    	  
	    	  ObjectMapper objectMapper = new ObjectMapper();
	            String json = objectMapper.writeValueAsString(data);

	        try (CloseableHttpClient client = HttpClients.createDefault()) {
	            HttpPost post = new HttpPost(url);
	            post.setHeader("Content-Type", "application/json");
	            post.setEntity(new StringEntity(json));

	            try (CloseableHttpResponse response = client.execute(post)) {
	                String responseBody = EntityUtils.toString(response.getEntity());

	            statusCode=  response.getStatusLine().getStatusCode();
	         // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(responseBody);
                
                 refreshToken = jsonResponse.getString("refreshToken");
                System.out.println("refreshToken:" + refreshToken);
            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return statusCode;
	    }
	}

