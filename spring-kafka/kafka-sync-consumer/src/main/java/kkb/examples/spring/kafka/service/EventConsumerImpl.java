package kkb.examples.spring.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import kkb.examples.spring.kafka.events.AsyncEvent;
import kkb.examples.spring.kafka.events.EventWrapper;
import kkb.examples.spring.kafka.events.TxMessageAsyncEvent;
import kkb.examples.spring.kafka.service.EventConsumerImpl;
import kkb.examples.spring.kafka.service.EventPublishException;


@Service
public class EventConsumerImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventConsumerImpl.class);

    private static final String REQUEST_TOPIC  = "sync-prod-con-requests";
    private static final String RESPONSE_TOPIC = "sync-prod-con-responses";

    private final KafkaTemplate<String, EventWrapper<? extends AsyncEvent>> kafkaTemplate;

    public EventConsumerImpl(@Autowired KafkaTemplate<String, EventWrapper<? extends AsyncEvent>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = REQUEST_TOPIC)
    public void consume(EventWrapper<? extends AsyncEvent> message) {
        LOGGER.info("#### Consumed message -> {}", message.getType());
        if (message.getType().equals(TxMessageAsyncEvent.class)) {
            EventWrapper<TxMessageAsyncEvent> wrapper = (EventWrapper<TxMessageAsyncEvent>)message;
            TxMessageAsyncEvent txMessageAsyncEvent = wrapper.getEvent();
            sendMessage(txMessageAsyncEvent);
        } else {
            LOGGER.error("ERROR: unsupported message type {}", message.getType());
        }
    }

    public void sendMessage(TxMessageAsyncEvent message) throws EventPublishException {
        try {
            String messageKey = message.getId();
            LOGGER.info("#### Producing message: {} {}", message.getId(), message.getMessage());
            ListenableFuture<SendResult<String, EventWrapper<? extends AsyncEvent>>> send = this.kafkaTemplate.send(RESPONSE_TOPIC, messageKey, new EventWrapper<>(message));
            send.get();
        } catch (Exception e) {
            throw new EventPublishException("Kafka publish DataMessage exception", e);
        }
    }

}
