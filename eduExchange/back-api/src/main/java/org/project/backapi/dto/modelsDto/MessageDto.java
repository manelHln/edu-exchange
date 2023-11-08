package org.project.backapi.dto.modelsDto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter
public class MessageDto {
    private Long id;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;
    private Long authorId;
    private  Long conversationId;
}
