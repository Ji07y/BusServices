package org.example;

import Publisher.AlarmEventPublisher;
import processor.TicketProcessor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        public static void main(String[] args) {
            // Publicar un evento de alarma
            AlarmEventPublisher.main(new String[]{});

            // Procesar el mensaje y generar un ticket
            TicketProcessor.main(new String[]{});
        }
}

