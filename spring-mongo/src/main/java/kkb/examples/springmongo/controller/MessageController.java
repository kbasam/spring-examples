package kkb.examples.springmongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kkb.examples.springmongo.dto.CreateRequest;
import kkb.examples.springmongo.dto.Message;
import kkb.examples.springmongo.dto.MessageId;
import kkb.examples.springmongo.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/services")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    ResponseEntity<List<Message>> getAll() {
        return ResponseEntity.ok(messageService.getAll());
    }

    @PostMapping("/messages")
    ResponseEntity<MessageId> saveMessage(@RequestBody CreateRequest message) {
        return ResponseEntity.ok(messageService.saveMessage(message));
    }

    @DeleteMapping("/messages/{id}")
    ResponseEntity<Void> delete(@PathVariable String id) {
        messageService.delete(new MessageId(id));
        return ResponseEntity.ok().build();
    }

}
