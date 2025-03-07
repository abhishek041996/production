package Apis;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class verifyAndSignUpAPI {
	private String otp; // Declare otp variable here

    public int test(String emailId) {
        int statusCode1;
        fetchOtp(); // Fetch the OTP from the latest email
        
        Map<Object, String> data = new LinkedHashMap<>();
        data.put("email", emailId);
        data.put("displayName", "abhishek123");
        data.put("password", "India@12345");
        
        
        data.put("otp", otp); // Use the fetched OTP
        
        System.out.println("Using OTP: " + otp); // Print the OTP for debugging
        
        // Sending the request to the API
        Response response = given()
                .when()
                .body(data)
                .header("Content-Type", "application/json")
                .post("https://emc-api.ddns.net/verifyAndSignUp")
                .then()
                .extract()
                .response();

     //   System.out.println(response.prettyPrint());
          statusCode1 = response.thenReturn().statusCode();
//        Serenity.recordReportData()
//        .withTitle("API Response")
//        .andContents(response.prettyPrint());
        System.out.println("Response Status Code: " + statusCode1);
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

                // Check if the email contains OTP in the subject or content
                if (subject.contains("OTP") || content.contains("OTP")) {
                    System.out.println("OTP email found!");
                    System.out.println("OTP Email Content: " + content);

                    // Extract OTP from content
                    otp = extractOtp(content);
                    System.out.println("Attempting to extract OTP from content...");

                    if (otp != null) {
                        System.out.println("Extracted OTP: " + otp);
                    } else {
                        System.out.println("OTP not found in the email content.");
                    }
                } else {
                    System.out.println("This email does not contain an OTP.");
                }
            } else {
                System.out.println("No valid unread emails found.");
            }

            // Close inbox and store
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getTextFromMessage(Message message) throws Exception {
        StringBuilder result = new StringBuilder();
        String contentType = message.getContentType();

       
          if (message.isMimeType("text/html")) {
            String html = (String) message.getContent();
            result.append(org.jsoup.Jsoup.parse(html).text()); // Using Jsoup to parse HTML
          }else {
            result.append("This message contains unsupported content type: " + contentType);
        }
        return result.toString();
    }

   
    // Method to extract OTP from the content using regex
    private String extractOtp(String content) {
        String otpPattern = "\\b\\d{6}\\b"; // Regex to match a 6-digit OTP
        Pattern pattern = Pattern.compile(otpPattern);
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            return matcher.group(); // Return the first match found
        }
        return null; // Return null if no OTP is found
    }
}