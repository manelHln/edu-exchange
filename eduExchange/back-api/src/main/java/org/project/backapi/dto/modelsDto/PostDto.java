package org.project.backapi.dto.modelsDto;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.project.backapi.enums.PostStatus;

@Getter @Setter
public class PostDto {
    private Long id;
    @NotBlank(message = "Content is required")
    private String content;
    @NotBlank(message = "Title is required")
    private String title;
    private List<String> imagePaths;
    private Long userId;
    @NotBlank(message = "Topics are required")
    private Set<String> topicNames;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean hidden;
    private PostStatus status;
}
