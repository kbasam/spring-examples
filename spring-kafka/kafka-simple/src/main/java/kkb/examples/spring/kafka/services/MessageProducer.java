package kkb.examples.spring.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import kkb.examples.spring.kafka.events.DataMessageAsyncEvent;
import kkb.examples.spring.kafka.events.EventWrapper;

@Service
public class MessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);
    private static final String TOPIC = "simple-test-topic";

    private final KafkaTemplate<String, EventWrapper<DataMessageAsyncEvent>> kafkaTemplate;

    public MessageProducer(@Autowired KafkaTemplate<String, EventWrapper<DataMessageAsyncEvent>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(EventWrapper<DataMessageAsyncEvent> message) {
        LOGGER.info("#### Producing message: {} {}", message.getEvent().getId(), message.getEvent().getMessage());
        this.kafkaTemplate.send(TOPIC, message);
    }

}
