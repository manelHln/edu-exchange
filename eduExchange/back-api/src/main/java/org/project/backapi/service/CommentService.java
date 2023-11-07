package org.project.backapi.service;

import jakarta.persistence.EntityNotFoundException;
import org.project.backapi.converter.CommentConverter;
import org.project.backapi.domain.Comment;
import org.project.backapi.domain.Post;
import org.project.backapi.domain.User;
import org.project.backapi.dto.modelsDto.CommentDto;
import org.project.backapi.dto.response.PagedResponse;
import org.project.backapi.exception.RessourceNotFoundException;
import org.project.backapi.repository.CommentRepository;
import org.project.backapi.repository.PostRepository;
import org.project.backapi.repository.UserRepository;
import org.project.backapi.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    @Autowired
    private CommentConverter commentConverter;

    public CommentDto createComment(CommentDto commentDto) {

        // Recherche du post et de l'utilisateur en fonction de leurs IDs
        Post post = postRepository.findById(commentDto.getPostId())
                .orElseThrow(() -> new RessourceNotFoundException(
                        String.format("Post: %d does not exist", commentDto.getPostId())));
        User author = userRepository.findById(commentDto.getAuthorId())
                .orElseThrow(() -> new RessourceNotFoundException(String.format(
                        "User: %d, does not exist.", commentDto.getAuthorId())));
        Comment parentComment = null;
        if (commentDto.getParentId() != null) {
            parentComment = commentRepository.findById(commentDto.getParentId())
                    .orElseThrow(() -> new EntityNotFoundException("Comment not found"));
        }

        Comment comment = commentConverter.convert(commentDto, author, parentComment, post);
        // Enregistrer le commentaire dans la base de données
        Comment savedComment = commentRepository.save(comment);

        // Convertir l'entité Comment en CommentDto et le renvoyer
        return commentConverter.convert(comment);
    }

    public PagedResponse<CommentDto> getAllCommentsByPostId(Long postId, int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RessourceNotFoundException(
                        String.format("Post: %d does not exist", postId)));

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

        Page<Comment> rootCommentsPage = commentRepository.findByParentIsNullAndPostId(postId, pageable);

        List<CommentDto> rootCommentDtos = rootCommentsPage.getContent().stream()
                .map(rootComment -> {
                    CommentDto dto = commentConverter.convert(rootComment);
                    dto.setReplies(getRepliesToComment(rootComment.getId()));
                    return dto;
                })
                .toList();

        return new PagedResponse<>(rootCommentDtos, rootCommentsPage.getNumber(), rootCommentsPage.getSize(), rootCommentsPage.getTotalElements(), rootCommentsPage.getTotalPages(), rootCommentsPage.isLast());

    }

    public List<CommentDto> getRepliesToComment(Long commentId) {
        List<Comment> replies = commentRepository.findByParentId(commentId);

        //return commentConverter.convert(commentRepository.findByParentId(commentId));
        return replies.stream()
                .map(reply -> {
                    CommentDto dto = commentConverter.convert(reply);
                    dto.setReplies(getRepliesToComment(reply.getId()));
                    return dto;
                })
                .toList();
    }

    public CommentDto updateComment(Long commentId, String newContent) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RessourceNotFoundException(String.format("Comment: %d does not exist ", commentId)));
        comment.setContent(newContent);
        Comment updatedComment = commentRepository.save(comment);

        return commentConverter.convert(updatedComment);
    }
    public String delete(Long id) {
        commentRepository.deleteById(id);
        return "Comment deleted successfully";
    }
}
