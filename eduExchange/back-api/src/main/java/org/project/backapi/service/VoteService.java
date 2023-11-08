package org.project.backapi.service;

import org.project.backapi.domain.Comment;
import org.project.backapi.domain.User;
import org.project.backapi.domain.Vote;
import org.project.backapi.enums.VoteStatus;
import org.project.backapi.exception.ResourceNotFoundException;
import org.project.backapi.repository.CommentRepository;
import org.project.backapi.repository.UserRepository;
import org.project.backapi.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    @Autowired
    public VoteService(
            VoteRepository voteRepository,
            CommentRepository commentRepository,
            UserRepository userRepository) {

        this.voteRepository = voteRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public Vote createVote(Long commentId, Long userId, VoteStatus voteStatus) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Vote vote = new Vote();
        vote.setComment(comment);
        vote.setUser(user);
        vote.setVoteStatus(VoteStatus.fromInt(voteStatus));
        return voteRepository.save(vote);
    }



}
