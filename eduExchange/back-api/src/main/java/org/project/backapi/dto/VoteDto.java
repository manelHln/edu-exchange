package org.project.backapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.project.backapi.enums.VoteStatus;

@Getter
@Setter
@Data
public class VoteDto {
    private Long id;
    private VoteStatus status;
}
