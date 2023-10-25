package kkb.examples.springmongo.service;

import java.util.List;

import kkb.examples.springmongo.dto.CreateRequest;
import kkb.examples.springmongo.dto.Message;
import kkb.examples.springmongo.dto.MessageId;

public interface MessageService {

    List<Message> getAll();
    MessageId saveMessage(CreateRequest request);

    void delete(MessageId id);

}
