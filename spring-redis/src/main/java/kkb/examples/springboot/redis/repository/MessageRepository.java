package kkb.examples.springboot.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kkb.examples.springboot.redis.model.MessageData;

@Repository
public interface MessageRepository extends CrudRepository<MessageData, String> {
}
