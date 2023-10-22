package org.project.backapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity(name = "edu")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EduUser extends User{
    @Column(name = "fullname")
    private String fullname;

    @Column(name = "pseudo")
    private String pseudo;


    //relations
    @OneToMany(mappedBy = "edu")
    private Set<Vote> votes;

    @OneToMany(mappedBy = "edu")
    @ToString.Exclude
    private Set<Comment> comments;

    @OneToMany(mappedBy = "edu")
    @ToString.Exclude
    private Set<Post> posts;

    @OneToMany(mappedBy = "initiator")
    @ToString.Exclude
    private Set<Conversation> initiatedConversations;

    @OneToMany(mappedBy = "receiver")
    @ToString.Exclude
    private Set<Conversation> receivedConversations;

    @OneToMany(mappedBy = "sender")
    @ToString.Exclude
    private Set<Message> messages;
}