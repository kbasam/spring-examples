package kkb.examples.spring.kafka.service;

import java.util.concurrent.CompletableFuture;

import kkb.examples.spring.kafka.dto.MessageReply;

public interface EventConsumer {

    void setTransaction(String txId, CompletableFuture<MessageReply> completableFuture);

}
