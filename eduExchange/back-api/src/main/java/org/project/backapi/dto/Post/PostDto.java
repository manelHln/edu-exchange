package org.project.backapi.dto.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostDto {
    private Long id;
    private String content;
    private List<String> imagePaths;
    private LocalDateTime createdAt;
    private Long userId;
    private Set<Long> topicIds;
    private Set<String> topicNames;
}
