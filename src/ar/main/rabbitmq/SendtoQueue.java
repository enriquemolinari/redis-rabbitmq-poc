package ar.main.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SendtoQueue {

  private static final String QUEUE_NAME = "HELLO";

  public static void main(String[] args) throws IOException, TimeoutException {
    // rabbit image with management plugin
    // docker run -d --name some-rabbit -p 5672:5672 -p 15672:15672
    // rabbitmq:3-management

    // sudo docker ps //check images running
    // sudo docker stop some-rabbit
    // sudo docker rm some-redis
    // console mamangement: localhost:15672 (guest/guest)
    // para ver los mensajes enviados, voy a Queues (o que que utilice), y luego
    // "Get Messages"

    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
      channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      String message = "Hola Enrique";
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      System.out.println(" [x] Sent '" + message + "'");
    }
  }

}
