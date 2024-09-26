package com.side_project.daily_assistant.adapter.out.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByPostId(Long postId);

    @Query("SELECT c FROM CommentEntity c " +
            "JOIN CommentClosureEntity cc ON c.id = cc.childComment.id " +
            "WHERE c.post.id = :postId AND cc.parentComment.id IS NULL")
    List<CommentEntity> findTopLevelCommentsByPostId(@Param("postId") Long postId);

    @Query("SELECT cc.childComment FROM CommentClosureEntity cc WHERE cc.parentComment.id = :parentId")
    List<CommentEntity> findChildCommentsByParentId(@Param("parentId") Long parentId);

    @Query("SELECT COUNT(cc) FROM CommentClosureEntity cc WHERE cc.parentComment.id = :parentId")
    int countRepliesByParentId(@Param("parentId") Long parentId);
}
