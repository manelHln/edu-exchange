package org.project.backapi.service;

import lombok.RequiredArgsConstructor;
import org.project.backapi.converter.MessageConverter;
import org.project.backapi.domain.Message;
import org.project.backapi.dto.MessageDto;
import org.project.backapi.repository.MessageRepository;
import org.project.backapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    @Autowired
    private final MessageRepository messageRepository;

    public List<Message> loadMessage() {
       return messageRepository.findAll();
    }
    public MessageConverter searchMessage(Long id) {
        return messageRepository.findById(id);
    }
    public MessageConverter sendMessage (MessageDto message) {
       return messageRepository.save(message);
    }


}
