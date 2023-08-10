package com.example.kafkastreamsproducer.kafka;

import com.example.commonlibrary.dto.Health;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HealthDataProducer {
    private final NewTopic topic;

    private final KafkaTemplate<String, Health> kafkaTemplate;

    public HealthDataProducer(NewTopic topic, KafkaTemplate<String, Health> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Health health) {
        log.info(String.format("Health => %s", health.toString()));
        Message<Health> message = MessageBuilder
                .withPayload(health)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}
