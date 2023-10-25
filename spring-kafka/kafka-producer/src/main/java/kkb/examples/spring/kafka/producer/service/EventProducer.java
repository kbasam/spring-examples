package kkb.examples.spring.kafka.producer.service;

import kkb.examples.spring.kafka.events.AccountAsyncEvent;
import kkb.examples.spring.kafka.events.DataMessageAsyncEvent;

public interface EventProducer {

    void sendMessage(DataMessageAsyncEvent message) throws EventPublishException;

    void sendAccountMessage(AccountAsyncEvent accountAsyncEvent) throws EventPublishException;

}
