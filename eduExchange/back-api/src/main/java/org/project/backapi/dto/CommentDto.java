package org.project.backapi.dto;

import lombok.Getter;
import lombok.Setter;
import org.project.backapi.domain.User;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CommentDto {
    private String content;
    private User user;
    private List<String> imagePaths;
    private Long parentId;
}
