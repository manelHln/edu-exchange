package org.project.backapi.controller;

import org.project.backapi.domain.Topic;
import org.project.backapi.dto.Post.TopicDto;
import org.project.backapi.service.PostService;
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
    public ResponseEntity<?> getTopicPosts(
            @PathVariable String topicName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(postService.getTopicPosts(topicName, page, size), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDto>> getAllTopics(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Topic> topicPage = postService.getAllTopics(page, size);
        List<TopicDto> topicDtos = topicPage.getContent().stream()
                .map(TopicDto::new)
                .collect(Collectors.toList());

        Page<TopicDto> topicDtoPage = new PageImpl<>(topicDtos, topicPage.getPageable(), topicPage.getTotalElements());
        return ResponseEntity.ok(topicDtoPage);
    }
}
