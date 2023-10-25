package kkb.examples.springboot.redis.service;

import java.util.Collection;
import java.util.Optional;

import kkb.examples.springboot.redis.model.MessageData;

public interface MessageService {

    Collection<MessageData> getAll();

    Optional<MessageData> get(String id);

    void save(MessageData message);

    Optional<MessageData> delete(String id);

}
