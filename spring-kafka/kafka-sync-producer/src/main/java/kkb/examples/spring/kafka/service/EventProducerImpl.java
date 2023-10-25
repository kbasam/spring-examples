package kkb.examples.spring.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import kkb.examples.spring.kafka.events.AsyncEvent;
import kkb.examples.spring.kafka.events.EventWrapper;
import kkb.examples.spring.kafka.events.TxMessageAsyncEvent;
import kkb.examples.spring.kafka.service.EventPublishException;

@Service
public class EventProducerImpl implements EventProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventProducerImpl.class);
    private static final String TOPIC = "sync-prod-con-requests";

    private final KafkaTemplate<String, EventWrapper<? extends AsyncEvent>> kafkaTemplate;

    public EventProducerImpl(@Autowired KafkaTemplate<String, EventWrapper<? extends AsyncEvent>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(TxMessageAsyncEvent message) throws EventPublishException {
        try {
            String messageKey = message.getId();
            LOGGER.info("#### Producing message: {} {}", message.getId(), message.getMessage());
            ListenableFuture<SendResult<String, EventWrapper<? extends AsyncEvent>>> send = this.kafkaTemplate.send(TOPIC, messageKey, new EventWrapper<>(message));
            send.get();
        } catch (Exception e) {
            throw new EventPublishException("Kafka publish DataMessage exception", e);
        }
    }

}
