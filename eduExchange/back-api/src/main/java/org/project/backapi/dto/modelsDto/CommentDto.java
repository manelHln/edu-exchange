package org.project.backapi.dto.modelsDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String content;
    private List<String> imagePaths;
    private Long authorId;
    private Long postId;
    private Long parentId;
    private List<CommentDto> replies;
}
