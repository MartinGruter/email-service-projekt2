package se.iths.martin.emailserviceprojekt2.subscriber;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.martin.emailserviceprojekt2.config.RabbitConfig;
import se.iths.martin.emailserviceprojekt2.model.Order;
import se.iths.martin.emailserviceprojekt2.model.OrderItem;
import se.iths.martin.springmessenger.model.Email;
import se.iths.martin.springmessenger.service.MessageService;

@Component
@RequiredArgsConstructor
public class MessageSubscriber {
    private final MessageService messageService;


    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void subscribe(Order order) {

        System.out.println("Recieved message:" + orderToMessage(order));
        Email email = new Email();
        email.setRecipient(order.getCustomerName());
        email.setSubject("Your order");
        email.setMessage(orderToMessage(order));
        messageService.send(email);
    }

    public String orderToMessage(Order order) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order date: ").append(order.getOrderDate()).append("\n");
        stringBuilder.append("Total amount: ").append(order.getTotalPrice()).append(" SEK\n\n");
        stringBuilder.append("Items:\n");
        for (OrderItem item : order.getOrderItems()) {
            stringBuilder.append("- ")
                    .append(item.getName())
                    .append(" x ")
                    .append(item.getQuantity())
                    .append(" = ")
                    .append(item.getPrice())
                    .append(" SEK\n");
        }
        return stringBuilder.toString();
    }
}
