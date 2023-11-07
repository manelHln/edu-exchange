package org.project.backapi.controller;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.project.backapi.domain.Comment;
import org.project.backapi.domain.User;
import org.project.backapi.domain.Vote;
import org.project.backapi.enums.VoteStatus;
import org.project.backapi.exception.ResourceNotFoundException;
import org.project.backapi.repository.CommentRepository;
import org.project.backapi.repository.UserRepository;
import org.project.backapi.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
public class VoteController {
    private final VoteService voteService;
    @Autowired
    private SessionFactory sessionFactory;

    private UserRepository userRepository;
    private CommentRepository commentRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    /*
     * @PostMapping("/{commentId}/{userId}/{voteStatus}")
     * public ResponseEntity<Vote> createVote(@PathVariable Long
     * commentId, @PathVariable Long userId, @PathVariable VoteStatus voteStatus) {
     * Vote vote = voteService.createVote(commentId, userId, voteStatus);
     * return new ResponseEntity<>(vote, HttpStatus.CREATED);
     * }
     */
    @PostMapping("/create/{commentId}/{userId}/{voteStatus}")
    public ResponseEntity<Vote> createVote(@PathVariable Long commentId, @PathVariable Long userId,
            @PathVariable VoteStatus voteStatus) {
        Vote vote = voteService.createVote(commentId, userId, voteStatus);
        return new ResponseEntity<>(vote, HttpStatus.CREATED);
    }

    @GetMapping("/TrueVote/{commentId}")
    public ResponseEntity<Long> countTrueVotesByCommentId(@PathVariable Long commentId) {
        Long count = voteService.countTrueVotesByCommentId(commentId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/FalseVote/{commentId}")
    public ResponseEntity<Long> countFalseVotesByCommentId(@PathVariable Long commentId) {
        Long count = voteService.countFalseVotesByCommentId(commentId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
