package org.project.backapi.controller;

import org.project.backapi.dto.Post.PostDto;
import org.project.backapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PostDto request) {
        return new ResponseEntity<>(postService.createPost(request), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PostDto request) {
        return new ResponseEntity<>(postService.updatePost(request), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllRecipes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "content") String sortBy) {
        return new ResponseEntity<>(postService.getAll(page, size, sortBy), HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getTopic(@PathVariable Long postId) {
        return new ResponseEntity<>(postService.getOne(postId), HttpStatus.OK);
    }

}
