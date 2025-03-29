package com.jonathan.rabbitmq_consumer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    public static final String EXCHANGE="message_exchange";
    public static final String ROUTING_KEY_COLOR="KEY_COLOR";
    public static final String ROUTING_KEY_SHAPE="KEY_SHAPE";
    public static final String QUEUE_COLOR ="color_queue";
    public static final String QUEUE_SHAPE ="shape_queue";

    @Bean
    public Queue queueColor(){
        return new Queue(QUEUE_COLOR);
    }

    @Bean
    public Queue queueSHAPE(){
        return new Queue(QUEUE_SHAPE);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingColor(Queue queueColor, TopicExchange topicExchange){
        return BindingBuilder
                .bind(queueColor)
                .to(topicExchange)
                .with(ROUTING_KEY_COLOR);
    }

    @Bean
    public Binding bindingshape(Queue queueSHAPE, TopicExchange topicExchange){
        return BindingBuilder
                .bind(queueSHAPE)
                .to(topicExchange)
                .with(ROUTING_KEY_SHAPE);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connection){
        final var template = new RabbitTemplate(connection);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
