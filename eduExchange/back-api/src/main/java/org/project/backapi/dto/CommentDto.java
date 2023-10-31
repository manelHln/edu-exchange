package org.project.backapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class CommentDto {
    private Long id;
    private String content;
    private LocalDateTime created_at;
}
