package org.project.backapi.controller;

import jakarta.validation.Valid;
import org.project.backapi.configuration.CurrentUser;
import org.project.backapi.domain.User;
import org.project.backapi.dto.modelsDto.PostDto;
import org.project.backapi.dto.modelsDto.ReportDto;
import org.project.backapi.dto.response.PagedResponse;
import org.project.backapi.enums.UserRole;
import org.project.backapi.exception.ForbiddenAccessOperation;
import org.project.backapi.exception.RessourceNotFoundException;
import org.project.backapi.repository.UserRepository;
import org.project.backapi.service.CommentService;
import org.project.backapi.service.PostService;
import org.project.backapi.service.ReportService;
import org.project.backapi.service.UserService;
import org.project.backapi.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    UserRepository userRepository;
    @Autowired
    ReportService reportService;

    /*
     * @PostMapping
     * public ResponseEntity<?> save (@RequestBody @Valid PostDto request) {
     * return new ResponseEntity<>(postService.createPost(request),
     * HttpStatus.CREATED);
     * }
     */

    @PostMapping
<<<<<<< HEAD
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
=======
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<?> createPost(@RequestBody @Valid PostDto request) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        PostDto createdPostDto = postService.createPost(request, currentUser);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Post created successfully");
        response.put("post", createdPostDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PagedResponse<PostDto>> readVisiblePosts(
            @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

        //notice that we only fetch visible posts
        return new ResponseEntity<>(postService.getAll(page, size,true), HttpStatus.OK);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PagedResponse<PostDto>> readPosts(
            @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

        //notice that we only fetch visible posts
        return new ResponseEntity<>(postService.getAll(page, size,false), HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<?> updatePost(@RequestBody @Valid PostDto request, @PathVariable Long postId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        PostDto updatedPostDto = postService.updatePost(request, postId, currentUser);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Post updated successfully");
        response.put("post", updatedPostDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
>>>>>>> 6178dc7ba9399602d2d5af4beef86e938c077031
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> readPost(@PathVariable Long postId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        PostDto dto = postService.getOne(postId);

        if (dto.getHidden() && !currentUser.getUserRole().equals(UserRole.ADMIN)) {
            throw new ForbiddenAccessOperation("You do not have privileges to access this resource");
        }

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

<<<<<<< HEAD
=======
    @PostMapping("/{postId}/reports")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<?> reportPost(@RequestBody @Valid ReportDto request, @PathVariable Long postId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        ReportDto createdReportDto = reportService.create(request, postId, currentUser);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Post reported successfully");
        response.put("report", createdReportDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{postId}/hide")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> hidePost(@PathVariable Long postId) {

        PostDto hiddenPostDto = postService.hidePost(postId);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Post hidden successfully");
        response.put("post", hiddenPostDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{postId}/close")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<?> closePost(@PathVariable Long postId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        PostDto closedPostDto = postService.closePost(postId, currentUser);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Post closed successfully");
        response.put("post", closedPostDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<?> getCommentsOfPost(
            @PathVariable Long postId,
            @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

        return new ResponseEntity<>(commentService.getAllCommentsByPostId(postId, page, size), HttpStatus.OK);
    }

    @GetMapping("/{postId}/reports")
    public ResponseEntity<?> getReportsOfPost(
            @PathVariable Long postId,
            @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

        return new ResponseEntity<>(reportService.getAllPostReports(postId, page, size), HttpStatus.OK);
    }

    @GetMapping("/users/{userPseudo}")
    public ResponseEntity<?> getUserPosts(
            @PathVariable String userPseudo,
            @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

        return new ResponseEntity<>(postService.getUserPosts(userPseudo, page, size), HttpStatus.OK);
    }

>>>>>>> 6178dc7ba9399602d2d5af4beef86e938c077031
}
