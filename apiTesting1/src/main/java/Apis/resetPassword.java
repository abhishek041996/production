package Apis;

import static io.restassured.RestAssured.given;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import io.restassured.response.Response;

public class resetPassword {
	int statusCode1;
	 String code;
	 private String url;
	 private String redirectedURL;
	public int test() {
		fetchOtp();
		
	try {

        String encodedURL = redirectedURL;
        int index = encodedURL.indexOf('=') + 1;
        String base64EncodedData = encodedURL.substring(index);
        byte[] decodedBytes = Base64.getDecoder().decode(base64EncodedData);
        String decodedData = new String(decodedBytes, StandardCharsets.UTF_8);
        String decodedURL = URLDecoder.decode(decodedData, StandardCharsets.UTF_8.name());
        JSONObject jsonObject = new JSONObject(decodedURL);
        code = jsonObject.getString("code");
        System.out.println(code);
        } catch (Exception e) {
        e.printStackTrace();
        }
	    Map<Object,String>data=new LinkedHashMap<Object,String>();
	    data.put("email", "abhiamilkanthwar96@gmail.com");
	    data.put("password", "India@12345");
	    data.put("code",code);
	    Response response = given().header("Content-Type","application/json")
                            .body(data).when()
                            .post("https://emc-api.ddns.net/resetPassword")
        	                .then().extract().response();
        statusCode1= response.thenReturn().statusCode();
//        Serenity.recordReportData()
//        .withTitle("API Response")
//        .andContents(response.prettyPrint());
	    return statusCode1;
}
	 private void fetchOtp() {
	        // Set TLS version
	        System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1");
	        String host = "imap.gmail.com";
	        String username = "abhiamilkanthwar96@gmail.com"; // Your Gmail address
	        String password = "dxshsbkkwibicliu"; // Your Gmail password or App Password
	        Properties props = new Properties();
	        props.setProperty("mail.store.protocol", "imaps");

	        try {
	            Session session = Session.getDefaultInstance(props, null);
	            Store store = session.getStore();
	            store.connect(host, username, password);
	            // Open INBOX folder
	            Folder inbox = store.getFolder("INBOX");
	            inbox.open(Folder.READ_ONLY);

	            // Fetch all unseen messages from the inbox
	            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
	            System.out.println("Total unread emails: " + messages.length);
	            // Check if any unread emails were found
	            if (messages.length > 0) {
	                // Get the latest message
	                Message latestMessage = messages[messages.length - 1];
	                // Process the latest message
	                String subject = latestMessage.getSubject();
	                System.out.println("Latest Unread Email Subject: " + subject);
	                // Get the content
	                String content = getTextFromMessage(latestMessage);
	                System.out.println("Email Content: " + content); // Print email content for debugging
	             // Parse HTML using Jsoup
	                Document doc = Jsoup.parse(content);
	                // Look for the reset password button (e.g., an <a> tag with text "Reset Password")
	                Element resetButton = doc.selectFirst("a:contains(Reset Password)");
	                if (resetButton != null) {
	                     url = resetButton.attr("href");
	                    System.out.println("Reset Password Link: " + url);
	                    URL url1 = new URL(url);
	                    HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
	                    
	                    // Enable following redirects
	                    connection.setInstanceFollowRedirects(false);
	                    connection.setRequestMethod("GET");
	                    connection.connect();

	                    // Check for redirection response code (3xx)
	                    int responseCode = connection.getResponseCode();
	                    if (responseCode >= 300 && responseCode < 400) {
	                        // Extract the "Location" header (redirected URL)
	                         redirectedURL = connection.getHeaderField("Location");
	                        System.out.println("Redirected URL: " + redirectedURL);
	                    } } else {
	                    System.out.println("Reset Password button not found!");
	                }
	            }
	            // Close inbox and store
	            inbox.close(false);
	            store.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    private String getTextFromMessage(Message message) throws Exception {
	       // StringBuilder result = new StringBuilder();
	       
	        String html=null;
	        
	          if (message.isMimeType("text/html")) {
	        	System.out.println("y");
	             html = (String) message.getContent();
	        } 
	        return html;
	    }
	}
