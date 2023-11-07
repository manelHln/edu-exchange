    package org.project.backapi.controller;

    import com.sun.security.auth.UserPrincipal;
    import jakarta.validation.Valid;
    import org.project.backapi.domain.User;
    import org.project.backapi.dto.modelsDto.CommentDto;
    import org.project.backapi.service.CommentService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/comments")
    public class CommentController {
        @Autowired
        CommentService commentService;

        /*@Autowired
        public CommentController(CommentService commentService) {
            this.commentService = commentService;
        }*/

        @GetMapping("/{commentId}/replies")
        public ResponseEntity<List<CommentDto>> getRepliesToComment(@PathVariable Long commentId) {

            return new ResponseEntity<>(commentService.getRepliesToComment(commentId),HttpStatus.OK);
        }

        @PutMapping()
        public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto) {
            CommentDto updatedComment = commentService.updateComment(commentDto.getId(), commentDto.getContent());
            return new ResponseEntity<>(updatedComment, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Object> createComment(CommentDto commentDto) {

            return new ResponseEntity<>(commentService.createComment(commentDto), HttpStatus.CREATED);
        }

        //@PreAuthorize("authenticated")
        @PostMapping("/create")
        public ResponseEntity<Object> create(@RequestBody @Valid CommentDto commentDto, User currentUser) {

            return new ResponseEntity<>(commentService.createComment(commentDto, currentUser), HttpStatus.CREATED);
        }


    }
