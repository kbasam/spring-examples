package kkb.examples.spring.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import kkb.examples.spring.kafka.events.DataMessageAsyncEvent;
import kkb.examples.spring.kafka.events.EventWrapper;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

@Service
public class MessageConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    private final Map<String, CompletableFuture<DataMessageAsyncEvent>> counters;

    public MessageConsumer() {
        this.counters = new ConcurrentHashMap<>();
    }

    public Future<DataMessageAsyncEvent> getFuture(String id) {
        CompletableFuture future  = new CompletableFuture();
        counters.put(id, future);
        return future;
    }

    @KafkaListener(topics = "simple-test-topic", groupId = "the-group")
    public void consume(EventWrapper<DataMessageAsyncEvent> message) throws IOException {
        LOGGER.info("#### Consumed message -> {} {}", message.getEvent().getId(), message.getEvent().getMessage());
        CompletableFuture<DataMessageAsyncEvent> future = counters.remove(message.getEvent().getId());
        if (future != null) {
            future.complete(message.getEvent());
        }
    }

}
