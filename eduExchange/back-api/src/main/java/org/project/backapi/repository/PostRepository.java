package org.project.backapi.repository;

import org.project.backapi.domain.Comment;
import org.project.backapi.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

}
