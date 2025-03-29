package com.jonathan.rabbitmq_consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerListeners {

    @RabbitListener(queues = RabbitmqConfig.QUEUE_COLOR)
    public void readColorMsg(Models.Classroom classroom){
        log.info("Recibiendo salon:{}",classroom);
    }

    @RabbitListener(queues = RabbitmqConfig.QUEUE_SHAPE)
    public void readSHAPEMsg(Models.Students students){
        log.info("Recibiendo estudiante:{}",students);
    }
}
