package org.project.backapi.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.project.backapi.converter.CommentConverter;
import org.project.backapi.domain.Comment;
import org.project.backapi.domain.Post;
import org.project.backapi.domain.User;
import org.project.backapi.dto.CommentDto;
import org.project.backapi.repository.CommentRepository;
import org.project.backapi.repository.PostRepository;
import org.project.backapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public CommentDto createComment(CommentDto commentDto, Long postId, Long userId) {
        Comment comment = CommentConverter.convertToEntity(commentDto);

        // Recherche du post et de l'utilisateur en fonction de leurs IDs
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Associer le post et l'utilisateur au commentaire
        comment.setPost(post);
        comment.setUser(user);

        // Enregistrer le commentaire dans la base de données
        Comment savedComment = commentRepository.save(comment);

        // Convertir l'entité Comment en CommentDto et le renvoyer
        return CommentConverter.convert(savedComment);
    }

    public List<Comment> getAllCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public List<Comment> getRepliesToComment(Long commentId) {
        // Use the CommentRepository to fetch replies to a specific comment
        return commentRepository.findByParentId(commentId);
    }
}
