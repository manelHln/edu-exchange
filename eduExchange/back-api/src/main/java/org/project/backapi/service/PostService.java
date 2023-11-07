package org.project.backapi.service;

import org.project.backapi.converter.PostConverter;
import org.project.backapi.converter.TopicConverter;
import org.project.backapi.domain.Post;
import org.project.backapi.domain.Topic;
import org.project.backapi.domain.User;
import org.project.backapi.dto.modelsDto.PostDto;
import org.project.backapi.dto.modelsDto.TopicDto;
import org.project.backapi.dto.response.PagedResponse;
import org.project.backapi.exception.RequestNotAuthorizedException;
import org.project.backapi.exception.RessourceNotFoundException;
import org.project.backapi.repository.PostRepository;
import org.project.backapi.repository.TopicRepository;
import org.project.backapi.repository.UserRepository;
import org.project.backapi.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    TopicConverter topicConverter;
    @Autowired
    PostConverter postConverter;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TopicRepository topicRepository;

    public PostDto createPost(PostDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(
                        () -> new RessourceNotFoundException(String.format("User: %d, not found", dto.getUserId())));

        List<Topic> topics = dto.getTopicNames().stream().map(name -> topicRepository.findByName(name).orElseGet(() -> {
            Topic newTopic = new Topic();
            newTopic.setName(name);
            return topicRepository.save(newTopic);
        })).collect(Collectors.toList());

        Post post = postConverter.convert(dto, user, topics);
        post = postRepository.save(post);

        return postConverter.convert(post);
    }

    public PostDto updatePost(PostDto dto) {
        Post post = postRepository.findById(dto.getId())
                .orElseThrow(
                        () -> new RessourceNotFoundException(String.format("Post: %d does not exist", dto.getId())));

        if (!Objects.equals(post.getUser().getId(), dto.getUserId())) {
            throw new RequestNotAuthorizedException(String.format(
                    "User: %d is not the author of post: %d, operation rejected", dto.getUserId(), dto.getId()));
        }

        post.setContent(dto.getContent());
        post.setImagePaths(dto.getImagePaths());
        post.setTopics(dto.getTopicNames().stream().map(name -> topicRepository.findByName(name).orElseGet(() -> {
            Topic newTopic = new Topic();
            newTopic.setName(name);
            return topicRepository.save(newTopic);
        })).collect(Collectors.toList()));

        post = postRepository.save(post);

        return postConverter.convert(post);
    }

    public PagedResponse<TopicDto> getAllTopics(int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "name");
        Page<Topic> topics = topicRepository.findAll(pageable);

        if (topics.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), 0, 0, 0, 0, true);
        }
        List<TopicDto> dtos = topicConverter.convert(topics.getContent());

        return new PagedResponse<>(dtos, topics.getNumber(), topics.getSize(), topics.getTotalElements(), topics.getTotalPages(), topics.isLast());
    }


    public PagedResponse<PostDto> getAll(int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Post> posts = postRepository.findAll(pageable);
        if(posts.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), 0, 0, 0, 0, true);
        }
        List<PostDto> dtos = postConverter.convert(posts.getContent());

        return new PagedResponse<>(dtos, posts.getNumber(), posts.getSize(), posts.getTotalElements(), posts.getTotalPages(), posts.isLast());
    }

    public PostDto getOne(Long postId) {
        return postConverter.convert(postRepository.findById(postId)
                .orElseThrow(() -> new RessourceNotFoundException(String.format("Post: %d not found", postId))));
    }

    public PagedResponse<PostDto> getUserPosts(Long userId, String pseudo, int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        if (userRepository.findByPseudoOrId(pseudo, userId).isEmpty()) {
            throw new RessourceNotFoundException(String.format("User: %s, does not exist", pseudo + userId));
        }

        Set<Post> setPosts = userRepository.findByPseudoOrId(pseudo, userId).get().getPosts();
        Page<Post> posts = postRepository.findAll(pageable);
        if(posts.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), 0, 0, 0, 0, true);
        }
        List<PostDto> dtos = postConverter.convert(posts.getContent());

        return new PagedResponse<>(dtos, posts.getNumber(), posts.getSize(), posts.getTotalElements(), posts.getTotalPages(), posts.isLast());
    }

    public PagedResponse<PostDto> getTopicPosts(String topicName, int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "name");
        Topic topic = topicRepository.findByName(topicName)
                .orElseThrow(() -> new RessourceNotFoundException(String.format("Topic: %s, does not exist", topicName)));

        Page<Post> posts = postRepository.findByTopics(topic, pageable);

        if (posts.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), 0, 0, 0, 0, true);
        }
        List<PostDto> dtos = postConverter.convert(posts.getContent());

        return new PagedResponse<>(dtos, posts.getNumber(), posts.getSize(), posts.getTotalElements(), posts.getTotalPages(), posts.isLast());
    }
}
