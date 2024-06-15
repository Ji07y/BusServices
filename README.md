# Azure Service Bus Client

![image](https://github.com/Ji07y/BusServices/assets/85076732/40d1d13f-76f0-43b7-b8b7-dc6fd52645b0)


Este repositorio contiene un cliente para interactuar con Azure Service Bus. El cliente está diseñado para facilitar el envío y recepción de mensajes a través de colas y temas de Azure Service Bus utilizando el protocolo AMQP.

## Funcionalidades

- **Envío de mensajes:** Capacidad para enviar mensajes a colas y temas de Azure Service Bus.
- **Recepción de mensajes:** Recepción y procesamiento de mensajes recibidos de colas y suscripciones de temas.
- **Gestión de sesiones:** Soporte para la gestión de sesiones en colas que lo requieran.
- **Gestión de errores:** Manejo de errores y excepciones durante la comunicación con Azure Service Bus.

## Requisitos previos

- **Azure Subscription:** Se requiere una suscripción de Azure para crear y utilizar Azure Service Bus.
- **Cuenta de Service Bus:** Debes tener una cuenta de Azure Service Bus creada con las credenciales necesarias para autenticar el acceso desde la aplicación.

## Instalación

1. Clona este repositorio:

    ```bash
   git clone https://github.com/tu_usuario/azure-service-bus-client.git
2. Instala las dependencias necesarias:

    ```bash
      npm install

3. Instala las dependencias necesarias:
    ```bash
      export AZURE_SERVICEBUS_CONNECTION_STRING="<connection_string>"

## Uso
1. Envío de mensajes:
   
    ```bash
       const sender = require('./sender');
      
      // Enviar un mensaje a una cola
      sender.sendMessageToQueue('miCola', { mensaje: 'Hola Mundo!' });
      
      // Enviar un mensaje a un tema
      sender.sendMessageToTopic('miTema', 'miSuscripción', { mensaje: 'Hola Mundo!' });
2. Recepción de mensajes:
    
    ```bash
       const receiver = require('./receiver');

      // Recibir mensajes de una cola
      receiver.receiveMessagesFromQueue('miCola', messages => {
          messages.forEach(message => console.log(message.body));
      });
      
      // Recibir mensajes de una suscripción de un tema
      receiver.receiveMessagesFromSubscription('miTema', 'miSuscripción', messages => {
          messages.forEach(message => console.log(message.body));
      });
3. Gestión de sesiones:
     ```bash
           const sessionHandler = require('./sessionHandler');

          // Establecer y manejar sesiones en una cola
          sessionHandler.processSession('miCola');
4. Gestión de errores:
El cliente maneja errores y excepciones durante la comunicación con Azure Service Bus. Asegúrate de manejar adecuadamente los errores en tu aplicación.

