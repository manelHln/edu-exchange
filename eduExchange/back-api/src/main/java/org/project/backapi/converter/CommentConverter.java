package org.project.backapi.converter;

import org.modelmapper.ModelMapper;
import org.project.backapi.domain.Comment;
import org.project.backapi.dto.CommentDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentConverter {
    public CommentDto convert(Comment comment) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(comment, CommentDto.class);
    }

    public List<CommentDto> convert(List<Comment> comments) {
        ModelMapper modelMapper = new ModelMapper();
        List<CommentDto> converted = new ArrayList<>();
        for(Comment comment: comments) {
            converted.add(convert(comment));
        }
        return converted;
    }
}
