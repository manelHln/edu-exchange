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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;



    public String createComment(CommentDto commentDto, Long postId, Long userId) {

        // Recherche du post et de l'utilisateur en fonction de leurs IDs
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Comment parentComment = null;
        if(null != commentDto.getParentId()){
            parentComment = commentRepository.findById(commentDto.getParentId()).orElseThrow(()-> new EntityNotFoundException("Comment not found"));
        }

        Comment comment = Comment.builder()
                .imagePaths(commentDto.getImagePaths())
                .content(commentDto.getContent())
                .parent(parentComment)
                .post(post)
                .user(user)
                .build();

        // Enregistrer le commentaire dans la base de données
        Comment savedComment = commentRepository.save(comment);

        // Convertir l'entité Comment en CommentDto et le renvoyer
        return "Comment created successfully";
    }

    public List<Comment> getAllCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public List<Comment> getRepliesToComment(Long commentId) {
        // Use the CommentRepository to fetch replies to a specific comment
        return commentRepository.findByParentId(commentId);
    }

    public String delete(Long id) {
        commentRepository.deleteById(id);
        return "Comment deleted successfully";
    }
}
