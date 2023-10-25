package kkb.examples.spring.kafka.service;

import kkb.examples.spring.kafka.events.TxMessageAsyncEvent;
import kkb.examples.spring.kafka.service.EventPublishException;

public interface EventProducer {

    void sendMessage(TxMessageAsyncEvent message) throws EventPublishException;

}
