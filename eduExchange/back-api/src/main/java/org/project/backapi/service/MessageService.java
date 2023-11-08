package org.project.backapi.service;

import lombok.RequiredArgsConstructor;
import org.project.backapi.converter.MessageConverter;
import org.project.backapi.domain.Message;
import org.project.backapi.dto.MessageDto;
import org.project.backapi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    @Autowired
    private final MessageRepository messageRepository;

    public List<Message> loadMessage() {
       return messageRepository.findAll();
    }
    public Optional<Message> searchMessage(Long id) {
        return messageRepository.findById(id);
    }
    public  Message sendMessage (MessageDto messageDto) {
        Message message = Message.builder()
                .content(messageDto.getContent())
                .sender()
                .imagePaths()
                .conversation()
                .build();
        return  messageRepository.save(message);

    }


}
