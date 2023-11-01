package org.project.backapi.controller;

import lombok.RequiredArgsConstructor;
import org.project.backapi.converter.MessageConverter;
import org.project.backapi.domain.Message;
import org.project.backapi.dto.MessageDto;
import org.project.backapi.repository.MessageRepository;
import org.project.backapi.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/load")
    public List<Message> loadMessage() {
        return messageService.loadMessage();
    }
    @GetMapping("/search")
    public MessageConverter searchMessage(@PathVariable Long id) {
        return messageService.searchMessage(id);
    }
    @PostMapping("/send")
    public MessageConverter sendMessage (@RequestBody MessageDto message) {
        return messageService.sendMessage(message);
    }


}
