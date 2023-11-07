package org.project.backapi.dto.modelsDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {
    private Long id;
    private String content;
    private Long authorId;
}
