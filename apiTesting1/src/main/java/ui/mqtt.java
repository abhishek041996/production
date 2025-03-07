package ui;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class mqtt {

    public static void main(String[] args) {
        String host = "ws://mqtt-server.ddns.net"; // Use your MQTT broker host
        int port = 8083; // Use your MQTT broker port
        String path = "mqtt"; // Use your MQTT broker path if needed, otherwise leave it as an empty string
        String broker = String.format("%s:%d/%s", host, port, path);
        String clientId = "JavaSample";
        String[] topics = {"raw/3702", "raw/1392", "raw/5510"}; // Topics to subscribe to
        int qos = 2; // Quality of Service level

        try {
            MqttClient client = new MqttClient(broker, clientId);

            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost: " + cause.getMessage());
                    // Implement reconnection logic if needed
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("Message arrived. Topic: " + topic + " Message: " + new String(message.getPayload()));
                    // Validate the data here
                    validateMessage(topic, message);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("Delivery complete: " + token.isComplete());
                }
            });

            System.out.println("Connecting to broker: " + broker);
            client.connect(connOpts);
            System.out.println("Connected");

            System.out.println("Subscribing to topics: " + String.join(", ", topics));
            client.subscribe(topics, new int[]{qos, qos, qos}); // Subscribing to multiple topics

            // Publishing a message to one of the topics for testing
            String content = "Hello, MQTT!";
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            System.out.println("Publishing message to topic1: " + content);
            client.publish("topic1", message);
            System.out.println("Message published");

        } catch (MqttException me) {
            System.out.println("Reason: " + me.getReasonCode());
            System.out.println("Message: " + me.getMessage());
            System.out.println("Localized Message: " + me.getLocalizedMessage());
            System.out.println("Cause: " + me.getCause());
            System.out.println("Exception: " + me);
            me.printStackTrace();
        }
}
    private static void validateMessage(String topic, MqttMessage message) {
        // Implement your validation logic here
        System.out.println("Validating message for topic: " + topic);
        // Example: Check if the message payload contains specific text
        String payload = new String(message.getPayload());
        if (payload.contains("m_id")) {
            System.out.println("Validation passed for topic: " + topic);
        } else {
            System.out.println("Validation failed for topic: " + topic);
        }
    }}