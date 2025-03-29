package com.jonathan.rabbitmq_publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "publish")
@RequiredArgsConstructor
public class PublisherController {
    private final RabbitTemplate template;

    @PostMapping(path = "classroom")
    public  String publishColor(@RequestBody Models.Classroom classroom){
        this.template.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY_COLOR, classroom);
    return "Color send succes";
    }

    @PostMapping(path = "students")
    public  String publishStudent(@RequestBody Models.Students students){
        this.template.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY_SHAPE, students);
        return "Studentt send succes";
    }


}
