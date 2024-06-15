package processor;
import com.azure.messaging.servicebus.*;
import model.AlarmEvent;

import java.util.UUID;

public class TicketProcessor {
    private static final String CONNECTION_STRING = "your-connection-string";
    private static final String INCIDENTS_QUEUE_NAME = "incidents";
    private static final String TICKETS_QUEUE_NAME = "tickets";

    public static void main(String[] args) {
        ServiceBusClientBuilder clientBuilder = new ServiceBusClientBuilder()
                .connectionString(CONNECTION_STRING);

        ServiceBusReceiverClient receiverClient = clientBuilder
                .receiver()
                .queueName(INCIDENTS_QUEUE_NAME)
                .buildClient();

        ServiceBusSenderClient senderClient = clientBuilder
                .sender()
                .queueName(TICKETS_QUEUE_NAME)
                .buildClient();

        try {
            Iterable<ServiceBusReceivedMessage> messages = receiverClient.receiveMessages(10);
            for (ServiceBusReceivedMessage message : messages) {
                String alarmEventJson = message.getBody().toString();
                AlarmEvent alarmEvent = deserialize(alarmEventJson);

                String ticketId = generateTicket(alarmEvent);
                ServiceBusMessage ticketMessage = new ServiceBusMessage(ticketId);

                senderClient.sendMessage(ticketMessage);
                receiverClient.complete(message);
                System.out.println("Ticket generado y enviado: " + ticketId);
            }
        } finally {
            receiverClient.close();
            senderClient.close();
        }
    }

    private static AlarmEvent deserialize(String json) {
        // Implementa la lógica para convertir JSON a un objeto AlarmEvent
        // Este es un ejemplo simple y debe ser adaptado para un caso real
        return new AlarmEvent("Alarm1", "Critical");
    }

    private static String generateTicket(AlarmEvent alarmEvent) {
        // Lógica para generar un TicketId
        return UUID.randomUUID().toString();
    }
}
