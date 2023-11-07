package org.project.backapi.dto.modelsDto;

import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostDto {
    private Long id;
    private String content;
    private List<String> imagePaths;
    private Long userId;
    private Set<String> topicNames;
}
