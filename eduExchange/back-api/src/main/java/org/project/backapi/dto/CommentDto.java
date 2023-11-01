package org.project.backapi.dto;


import lombok.Getter;
import lombok.Setter;
import org.project.backapi.domain.User;

import java.time.LocalDateTime;

@Getter @Setter
public class CommentDto {
    private Long id;
    private String content;
    private User user;
    private LocalDateTime created_at;

}
