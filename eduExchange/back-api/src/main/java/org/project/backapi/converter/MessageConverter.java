package org.project.backapi.converter;

import org.modelmapper.ModelMapper;
import org.project.backapi.domain.Message;
import org.project.backapi.dto.MessageDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageConverter {
    public MessageDto convert(Message message) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(message, MessageDto.class);
    }

    public List<MessageDto> convert(List<Message> messages) {
        ModelMapper modelMapper = new ModelMapper();
        List<MessageDto> converted = new ArrayList<>();
        for (Message message : messages) {
            converted.add(convert(message));
        }
        return converted;
    }
}
