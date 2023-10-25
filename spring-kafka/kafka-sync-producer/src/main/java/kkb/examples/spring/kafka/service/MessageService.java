package kkb.examples.spring.kafka.service;

import java.util.concurrent.Future;

import kkb.examples.spring.kafka.dto.MessageReply;
import kkb.examples.spring.kafka.dto.MessageRequest;

public interface MessageService {

    Future<MessageReply> sendMessage(MessageRequest request);

}
