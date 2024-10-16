package com.side_project.daily_assistant.adapter.comment.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CommentClosureRepository extends JpaRepository<CommentClosureEntity, Long> {
    @Query("SELECT c.depth FROM CommentClosureEntity c WHERE c.childComment.id = :parentId")
    Optional<Integer> findDepthByParentCommentId(@Param("parentId") Long parentId);
}
