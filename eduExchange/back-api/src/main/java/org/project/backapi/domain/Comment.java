package org.project.backapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity @Table(name = "comment")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    // body of a comment, not sure if it will be String type due to String limit in dba
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private LocalDateTime created_at;

    @ElementCollection
    @CollectionTable(name = "comment_images", joinColumns = @JoinColumn(name = "comment_id"))
    @Column(name = "image_paths", nullable = true)
    private List<String> imagePaths;

    //relations
    //hierachisation of comments
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    //comment got  many votes
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comment")
    private List<Vote> votes;

    //comment belong to a single post
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;
    //comment belongs to a single user
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    //some methods for insertion and update of content
    @PrePersist
    protected void onCreate() {
        created_at  = LocalDateTime.now();
    }
}
