package org.project.backapi.repository;

import org.project.backapi.domain.Post;
import org.project.backapi.domain.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    //Page<Post> findAll(List<Post> setPosts, Pageable pageable);
    Page<Post> findAll(Pageable pageable);

    @Query("SELECT COUNT(p) FROM Post p JOIN p.topics t WHERE t = :topic")
    Long countByTopics(@Param("topic") Topic topic);

}
