package org.project.backapi.domain;

import jakarta.persistence.*;
import lombok.*;
import org.project.backapi.enums.VoteStatus;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private VoteStatus status;

    //vote belong to a single comment
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    private Comment comment;
    //vote belong to a single user
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "edu_id", referencedColumnName = "id")
    private EduUser edu;
}