package org.project.backapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity @Table(name = "conversation")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "initiator_id")
    private EduUser initiator;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id")
    private EduUser receiver;

    @OneToMany(mappedBy = "conversation")
    private Set<Message> messages;
}