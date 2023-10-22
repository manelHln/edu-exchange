package org.project.backapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.ToString;

import java.util.Set;

@Entity(name = "student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User{
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
