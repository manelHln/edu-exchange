package org.project.backapi.converter;

import org.modelmapper.ModelMapper;
import org.project.backapi.domain.Post;
import org.project.backapi.dto.PostDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostConverter {
    public PostDto convert(Post post) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(post, PostDto.class);
    }

    public List<PostDto> convert(List<Post> posts) {
        ModelMapper modelMapper = new ModelMapper();
        List<PostDto> converted = new ArrayList<>();
        for(Post post:posts) {
            converted.add(convert(post));
        }
        return converted;
    }
}
