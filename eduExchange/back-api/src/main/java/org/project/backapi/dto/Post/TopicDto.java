package org.project.backapi.dto.Post;

import lombok.Getter;
import lombok.Setter;
import org.project.backapi.domain.Topic;

@Getter @Setter
public class TopicDto {
    private Long id;
    private String name;

    public TopicDto(Topic topic) {
        this.id = topic.getId();
        this.name = topic.getName();
    }

}
