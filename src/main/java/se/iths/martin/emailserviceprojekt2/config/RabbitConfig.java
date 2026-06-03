package se.iths.martin.emailserviceprojekt2.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class RabbitConfig {

    public static final String QUEUE = "new-queue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    ApplicationRunner debugRabbit(Environment env) {
        return args -> {
            System.out.println("Rabbit host = " + env.getProperty("spring.rabbitmq.host"));
            System.out.println("Rabbit port = " + env.getProperty("spring.rabbitmq.port"));
            System.out.println("Rabbit vhost = " + env.getProperty("spring.rabbitmq.virtual-host"));
            System.out.println("Rabbit SSL = " + env.getProperty("spring.rabbitmq.ssl.enabled"));
            System.out.println("Rabbit queue = " + RabbitConfig.QUEUE);
        };
    }
}
