package org.project.backapi.service;

import lombok.RequiredArgsConstructor;
import org.project.backapi.converter.MessageConverter;
import org.project.backapi.domain.Conversation;
import org.project.backapi.domain.Message;
import org.project.backapi.domain.Topic;
import org.project.backapi.domain.User;
import org.project.backapi.dto.modelsDto.MessageDto;
import org.project.backapi.dto.modelsDto.TopicDto;
import org.project.backapi.dto.response.PagedResponse;
import org.project.backapi.repository.ConversationRepository;
import org.project.backapi.repository.MessageRepository;
import org.project.backapi.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageConverter messageConverter;
    @Autowired
    ConversationRepository conversationRepository;

    public List<Message> loadMessage() {
       return messageRepository.findAll();
    }

    public PagedResponse<MessageDto>loadMessage (int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "name");
        Page<Message> message = messageRepository.findAll(pageable);

        if (message.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), 0, 0, 0, 0, true);
        }
        List<MessageDto> dtos = messageConverter.convert(message.getContent());

        return new PagedResponse<>(dtos, message.getNumber(), message.getSize(), message.getTotalElements(), message.getTotalPages(), message.isLast());
    }
    
    public Optional<Message> searchMessage(Long id) {
        return messageRepository.findById(id);
    }
    public  Message sendMessage (MessageDto messageDto, User currentUser) {
        /*Conversation conversation = conversationRepository.findById(messageDto.getConversationId()).orElseThrow(
                ()
        )*/
       Message message = messageRepository.save(messageConverter.convert(messageDto));
        return  messageConverter.convert(message);

    }


}
