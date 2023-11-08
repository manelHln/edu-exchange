package org.project.backapi.controller;

<<<<<<< HEAD
import jakarta.validation.Valid;
import org.project.backapi.domain.Comment;
import org.project.backapi.domain.User;
import org.project.backapi.dto.CommentDto;
=======
import com.sun.security.auth.UserPrincipal;
import jakarta.validation.Valid;
import org.project.backapi.domain.User;
import org.project.backapi.dto.modelsDto.CommentDto;
import org.project.backapi.repository.UserRepository;
>>>>>>> 6178dc7ba9399602d2d5af4beef86e938c077031
import org.project.backapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{commentId}/replies")
    public ResponseEntity<List<Comment>> getRepliesToComment(@PathVariable Long commentId) {
        List<Comment> commentReplies = commentService.getRepliesToComment(commentId);
        return ResponseEntity.ok(commentReplies);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(commentService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable Long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    // Get all comments of specific post
    @PostMapping("create/{postId}/{userId}")
    public ResponseEntity<String> createComment(
            @PathVariable Long postId,
            @PathVariable Long userId,
            @RequestBody CommentDto commentDto) {

        // CommentDto savedCommentDto =
        // commentService.createComment(commentDto,postId,userId);
        return new ResponseEntity<>(commentService.createComment(commentDto, postId, userId), HttpStatus.CREATED);
=======
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserRepository userRepository;

    /*
     * @Autowired
     * public CommentController(CommentService commentService) {
     * this.commentService = commentService;
     * }
     */

    @GetMapping("/{commentId}/replies")
    public ResponseEntity<List<CommentDto>> getRepliesToComment(@PathVariable Long commentId) {

        return new ResponseEntity<>(commentService.getRepliesToComment(commentId), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> updateComment(@RequestBody CommentDto commentDto) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        CommentDto updatedCommentDto = commentService.updateComment(commentDto.getId(), commentDto.getContent(), currentUser);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Comment updated successfully");
        response.put("post", updatedCommentDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*@PostMapping
    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    public ResponseEntity<Object> createComment(CommentDto commentDto) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        return new ResponseEntity<>(commentService.createComment(commentDto, currentUser), HttpStatus.CREATED);
    }*/

    // @PreAuthorize("authenticated")
    @PostMapping
    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    public ResponseEntity<Object> create(@RequestBody @Valid CommentDto commentDto) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        CommentDto createdCommentDto = commentService.createComment(commentDto, currentUser);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Comment created successfully");
        response.put("post", createdCommentDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
>>>>>>> 6178dc7ba9399602d2d5af4beef86e938c077031
    }

}
