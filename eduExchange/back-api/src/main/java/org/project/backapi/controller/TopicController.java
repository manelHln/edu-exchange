package org.project.backapi.controller;

import org.project.backapi.domain.Post;
import org.project.backapi.domain.Topic;
import org.project.backapi.dto.modelsDto.PostDto;
import org.project.backapi.dto.modelsDto.TopicDto;
import org.project.backapi.dto.response.PagedResponse;
import org.project.backapi.service.PostService;
import org.project.backapi.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    PostService postService;

    @GetMapping("/{topicName}")
    public ResponseEntity<PagedResponse<PostDto>> getTopicPosts(
            @PathVariable String topicName,
<<<<<<< HEAD
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
=======
            @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
>>>>>>> 6178dc7ba9399602d2d5af4beef86e938c077031
        return new ResponseEntity<>(postService.getTopicPosts(topicName, page, size), HttpStatus.OK);
    }

    @GetMapping
<<<<<<< HEAD
    public ResponseEntity<Page<TopicDto>> getAllTopics(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Topic> topicPage = postService.getAllTopics(page, size);
        List<TopicDto> topicDtos = topicPage.getContent().stream()
                .map(TopicDto::new)
                .collect(Collectors.toList());

        Page<TopicDto> topicDtoPage = new PageImpl<>(topicDtos, topicPage.getPageable(), topicPage.getTotalElements());
        return ResponseEntity.ok(topicDtoPage);
=======
    public ResponseEntity<PagedResponse<TopicDto>> getAllTopics(
            @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        return new ResponseEntity<>(postService.getAllTopics(page, size), HttpStatus.OK);
>>>>>>> 6178dc7ba9399602d2d5af4beef86e938c077031
    }
}
