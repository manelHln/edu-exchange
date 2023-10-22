package org.project.backapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity(name = "edu")
//@PrimaryKeyJoinColumn(name = "user_id")
public class EduUser extends User{
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