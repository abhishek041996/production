package Apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jcraft.jsch.*;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class mongo {
	static String [] meters= {//"8465"
			"6465",
			"6938",
			"6717"
//			"8786",
//			"8809"
//			"8436",
//			"8467",
//			"8455",
//			"8398",
//			"8479",
//			"8405",
//			"8410",
//			"8475",
//			"8462",
//			"8457",
//			"8461",
//			"8449",
//			"8468",
//			"8399",
//			"8439",
//			"8473",
//			"8441",
//			"5627",
//			"5661",
//			"5659",
//			"8396"
			};
		    
	 static String HOST = "ws://mqtt-server.ddns.net";
     static int PORT = 8083;
     static  String PATH = "mqtt";
     static  String BROKER = String.format("%s:%d/%s", HOST, PORT, PATH);
     static  String CLIENT_ID = "JavaSample";
     static  int QOS = 2;
     static  String[] TOPICS ;

    public static void main(String[] args) {
    	Map<String,Object>data=new LinkedHashMap<String,Object>();
		data.put("sensorIds",meters);
		data.put("organizationId","6797c0e3674b25865b66e448");
	    Response response = given().when()
	    		            .header("Content-Type","application/json").body(data)
			                .post("https://emc-api.ddns.net/mapBotToAccount").then()
			                .extract().response();
	    int statusCode= response.statusCode();
                System.out.println(statusCode);
    	
                
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////               
//////////////////////////////////////////////////////////////////////////////////////////////////
                
                /////////////////////////////               
                
        String host = "65.0.104.217";
        String user = "ubuntu";
        String privateKey = "C:/Users/Abhishek/Documents/jump-host-1.pem";

        String meterIdStr = String.join(",", meters);

        // MongoDB updateMany command
        String mongoCommand = "mongosh --host 172.31.9.254 --quiet --eval \""
                + "db.getSiblingDB(\\\"sustdash\\\").firmware.updateMany({\\\"meter_id\\\": {\\$in: ["
                + meterIdStr
                + "]}}, {\\$set: {force_version: NumberInt(606), update_url: \\\"http://api-server.ddns.net/fetchBinary/673b1bdd9d1c76709ff86d6e\\\"}})\"";


        try {
            JSch jsch = new JSch();
            jsch.addIdentity(privateKey);

            Session session = jsch.getSession(user, host, 22);
            session.setConfig("StrictHostKeyChecking", "no");

            System.out.println("Connecting to server...");
            session.connect();
            System.out.println("Connected successfully!");
            System.out.println("Executing: " + mongoCommand);

            executeCommand(session, mongoCommand);

            session.disconnect();
            System.out.println("\nSession disconnected.");
        } catch (JSchException e) {
            System.err.println("SSH Connection Error: " + e.getMessage());
        }
    }

    private static void executeCommand(Session session, String command) {
        ChannelExec channel = null;
        InputStream input = null;

        try {
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            channel.setInputStream(null);
            channel.setErrStream(System.err);
            input = channel.getInputStream();

            channel.connect();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, bytesRead));
            }

        } catch (Exception e) {
            System.err.println("Command Execution Error: " + e.getMessage());
        } finally {
            // Explicitly close resources
            if (channel != null) channel.disconnect();
            try {
                if (input != null) input.close();
            } catch (Exception e) {
                System.err.println("Error closing input stream: " + e.getMessage());
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    try {
    	TOPICS = Arrays.stream(meters)
                .map(m -> "restart/" + m)
                .toArray(String[]::new);
        // Create MQTT client
        MqttClient client = new MqttClient(BROKER, CLIENT_ID, new MemoryPersistence());

        // Set callback for connection loss and message delivery
        client.setCallback(new MqttCallback() {
            public void connectionLost(Throwable cause) {
                System.out.println("Connection lost: " + cause.getMessage());
            }

            public void messageArrived(String topic, MqttMessage message) {
                System.out.println("Message received on topic " + topic + ": " + new String(message.getPayload()));
            }

            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("Message delivered");
            }
        });

        // Connect to the broker
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        client.connect(options);
        System.out.println("Connected to MQTT broker: " + BROKER);

        // JSON payload
        String jsonPayload = "{}";
        MqttMessage message = new MqttMessage(jsonPayload.getBytes());
        message.setQos(QOS);
        

        // Publish message to multiple topics
        for (String topic : TOPICS) {
            client.publish(topic, message);
            System.out.println("Message published to topic: " + topic);
        }

        // Disconnect
        client.disconnect();
        System.out.println("Disconnected");

    } catch (MqttException e) {
        e.printStackTrace();
    }
}
}
