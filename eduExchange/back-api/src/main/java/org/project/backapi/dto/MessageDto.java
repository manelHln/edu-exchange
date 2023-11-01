package org.project.backapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class MessageDto {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
}
