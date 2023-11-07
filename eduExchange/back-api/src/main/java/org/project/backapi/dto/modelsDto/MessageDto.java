package org.project.backapi.dto.modelsDto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationManager;

import java.time.Instant;


@Getter
@Setter
public class MessageDto {
    private Long id;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;
    private Long authorId;
    private Long receiverId;
    private Long conversationId;
}
