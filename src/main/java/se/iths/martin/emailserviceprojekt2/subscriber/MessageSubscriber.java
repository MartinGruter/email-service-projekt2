package se.iths.martin.emailserviceprojekt2.subscriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.martin.emailserviceprojekt2.config.RabbitConfig;
import se.iths.martin.emailserviceprojekt2.model.Message;

@Component
public class MessageSubscriber {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void subscribe(Message message) {
        System.out.println("Recieved message:" + message.getContent());
    }
}
