package org.project.backapi.service;

import org.project.backapi.converter.PostConverter;
import org.project.backapi.domain.Post;
import org.project.backapi.domain.Topic;
import org.project.backapi.domain.User;
import org.project.backapi.dto.Post.PostDto;
import org.project.backapi.exception.RequestNotAuthorizedException;
import org.project.backapi.exception.RessourceNotFoundException;
import org.project.backapi.repository.PostRepository;
import org.project.backapi.repository.TopicRepository;
import org.project.backapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostConverter postConverter;
    @Autowired
    UserRepository userRepository;
   @Autowired
   TopicRepository topicRepository;


    public PostDto createPost(PostDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RessourceNotFoundException(String.format("User: %d, not found",dto.getUserId())));

        Set<Topic> topics = dto.getTopicNames().stream().map(name -> topicRepository.findByName(name).orElseGet(() -> {
            Topic newTopic = new Topic();
            newTopic.setName(name);
            return topicRepository.save(newTopic);
        })).collect(Collectors.toSet());

        Post post = postConverter.convert(dto, user, topics);
        post = postRepository.save(post);

        return postConverter.convert(post);
    }

    public PostDto updatePost(PostDto dto) {
        Post post = postRepository.findById(dto.getId())
                .orElseThrow(() -> new RessourceNotFoundException(String.format("Post: %d does not exist",dto.getId())));

        if (!Objects.equals(post.getUser().getId(), dto.getUserId())) {
                throw  new RequestNotAuthorizedException(String.format("User: %d is not the author of post: %d, operation rejected",dto.getUserId(), dto.getId()));
        }

        post.setContent(dto.getContent());
        post.setImagePaths(dto.getImagePaths());
        post.setTopics(dto.getTopicNames().stream().map(name -> topicRepository.findByName(name).orElseGet(() -> {
            Topic newTopic = new Topic();
            newTopic.setName(name);
            return topicRepository.save(newTopic);
        })).collect(Collectors.toSet()));

        post = postRepository.save(post);

        return postConverter.convert(post);
    }

    public Page<Topic> getAllTopics(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return topicRepository.findAll(pageable);
    }

    /*public Long getTotalPostCountForTopic(Topic topic) {
        return postRepository.countByTopics(topic);
    }*/

    public List<PostDto> getAll (int page,int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        List<Post> posts = postRepository.findAll(pageable).getContent();
        return postConverter.convert(posts);
    }

    public PostDto getOne(Long postId) {
        return postConverter.convert(postRepository.findById(postId).orElseThrow( () -> new RessourceNotFoundException(String.format("Post: %d not found", postId))));
    }

    public List<PostDto> getUserPosts(Long userId, String pseudo, int page, int size) {
        if(userRepository.findByPseudoOrId(pseudo, userId).isEmpty()) {
            throw new RessourceNotFoundException(String.format("User: %s, does not exist", pseudo+userId));
        }

        Pageable pageable = PageRequest.of(page, size);
        Set<Post> setPosts = userRepository.findByPseudoOrId(pseudo, userId).get().getPosts();
        //Page<Post> pagedPosts = postRepository.findAll(new ArrayList<>(setPosts), pageable);
        Page<Post> pagedPosts = postRepository.findAll(pageable);

        return postConverter.convert(pagedPosts.getContent());
    }

    public List<PostDto> getTopicPosts(String topicName, int page, int size) {
        if(topicRepository.findByName(topicName).isEmpty()) {
            throw new RessourceNotFoundException(String.format("Topic: %s, does not exist", topicName));
        }

        Pageable pageable = PageRequest.of(page, size);
        Topic topic = topicRepository.findByName(topicName).get();
        //Page<Post> pagedPosts = postRepository.findAll(topic.getPosts(), pageable);
        Page<Post> pagedPosts = postRepository.findAll(pageable);

        return postConverter.convert(pagedPosts.getContent());
    }
}
