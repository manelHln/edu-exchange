package org.project.backapi.controller;

import jakarta.validation.Valid;
import org.project.backapi.configuration.CurrentUser;
import org.project.backapi.domain.User;
import org.project.backapi.dto.modelsDto.PostDto;
import org.project.backapi.dto.response.PagedResponse;
import org.project.backapi.exception.RessourceNotFoundException;
import org.project.backapi.repository.UserRepository;
import org.project.backapi.service.CommentService;
import org.project.backapi.service.PostService;
import org.project.backapi.service.UserService;
import org.project.backapi.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    /*@PostMapping
    public ResponseEntity<?> save (@RequestBody @Valid PostDto request) {
        return new ResponseEntity<>(postService.createPost(request), HttpStatus.CREATED);
    }*/

    @PutMapping("/{id}/hide")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> hidePost (@PathVariable Long postId) {

        return new ResponseEntity<>(postService.hidePost(postId),HttpStatus.OK);
    }
    @PostMapping
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<?> createPost (@RequestBody @Valid PostDto request) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        return new ResponseEntity<>(postService.createPost(request, currentUser), HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<?> updatePost (@RequestBody PostDto request, @PathVariable Long postId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        return new ResponseEntity<>(postService.updatePost(request,postId,currentUser), HttpStatus.OK);
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<?> getAllCommentsByPostId(
            @PathVariable Long postId,
            @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size
    ) {

        return new ResponseEntity<>(commentService.getAllCommentsByPostId(postId, page, size),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PagedResponse<PostDto>> readAllPosts(
            @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size
    ) {
        return new ResponseEntity<>(postService.getAll(page, size), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> readAPost(@PathVariable Long postId) {

        return new ResponseEntity<>(postService.getOne(postId), HttpStatus.OK);
    }

}
