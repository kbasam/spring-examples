package kkb.examples.springmongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kkb.examples.springmongo.dto.CreateRequest;
import kkb.examples.springmongo.dto.Message;
import kkb.examples.springmongo.dto.MessageId;
import kkb.examples.springmongo.repository.MessageDocument;
import kkb.examples.springmongo.repository.MessageRepository;
import kkb.examples.springmongo.service.MessageService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAll() {
        List<Message> result = new ArrayList<>();
        messageRepository.findAll().forEach(m -> {
            result.add(new Message(m.getId(), m.getMessage()));
        });
        return result;
    }

    @Override
    public MessageId saveMessage(CreateRequest request) {
        MessageDocument saved = messageRepository.save(new MessageDocument(null, request.message()));
        return new MessageId(saved.getId());
    }

    @Override
    public void delete(MessageId id) {
        messageRepository.deleteById(id.id());
    }

}
