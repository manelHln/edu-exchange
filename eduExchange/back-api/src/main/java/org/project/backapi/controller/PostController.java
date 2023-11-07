package org.project.backapi.controller;

import org.project.backapi.dto.modelsDto.PostDto;
import org.project.backapi.dto.response.PagedResponse;
import org.project.backapi.service.CommentService;
import org.project.backapi.service.PostService;
import org.project.backapi.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<?> save (@RequestBody PostDto request) {
        return new ResponseEntity<>(postService.createPost(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update (@RequestBody PostDto request) {
        return new ResponseEntity<>(postService.updatePost(request), HttpStatus.OK);
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
    public ResponseEntity<PagedResponse<PostDto>> getAllPosts(
            @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size
    ) {
        return new ResponseEntity<>(postService.getAll(page, size), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPost(@PathVariable Long postId) {
        return new ResponseEntity<>(postService.getOne(postId), HttpStatus.OK);
    }


}
