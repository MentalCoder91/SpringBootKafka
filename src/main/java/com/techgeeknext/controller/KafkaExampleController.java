package com.techgeeknext.controller;

import com.techgeeknext.entity.User;
import com.techgeeknext.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/techgeeknext-kafka/")
public class KafkaExampleController {

    @Autowired
    KafkaProducerService kafkaProducer;

    @GetMapping("/hello")
    public String hello(){

        return "Hwllo World";
    }

    @GetMapping(value = "/producer")
    public String sendMessage(@RequestBody User user)
    {
        kafkaProducer.send(user);
        return "Message sent Successfully to the Kafka topic techgeeknext-topic";
    }

}
