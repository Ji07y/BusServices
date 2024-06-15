
package Publisher;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import model.AlarmEvent;


public class AlarmEventPublisher {
    private static final String CONNECTION_STRING = "your-connection-string";
    private static final String QUEUE_NAME = "incidents";

    public static void main(String[] args) {
        ServiceBusClientBuilder clientBuilder = new ServiceBusClientBuilder()
                .connectionString(CONNECTION_STRING);

        ServiceBusSenderClient senderClient = clientBuilder
                .sender()
                .queueName(QUEUE_NAME)
                .buildClient();

        try {
            AlarmEvent alarmEvent = new AlarmEvent("Alarm1", "Critical");
            String messageContent = serialize(alarmEvent);
            ServiceBusMessage message = new ServiceBusMessage(messageContent);

            senderClient.sendMessage(message);
            System.out.println("Mensaje enviado: " + messageContent);
        } finally {
            senderClient.close();
        }
    }

    private static String serialize(AlarmEvent alarmEvent) {
        // Implementa la lógica para convertir AlarmEvent a un String JSON
        return "{ \"name\": \"" + alarmEvent.getName() + "\", \"severity\": \"" + alarmEvent.getSeverity() + "\" }";
    }
}
