package com.side_project.daily_assistant.adapter.comment.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByPostId(Long postId);

    @Query("SELECT c FROM CommentEntity c " +
            "JOIN FETCH c.post " +
            "JOIN CommentClosureEntity cc ON c.id = cc.childComment.id " +
            "WHERE c.post.id = :postId AND cc.parentComment.id IS NULL")
    List<CommentEntity> findTopLevelCommentsByPostId(@Param("postId") Long postId);

    @Query("SELECT c FROM CommentClosureEntity cc " +
            "JOIN cc.childComment c " +
            "JOIN FETCH c.post " +
            "WHERE cc.parentComment.id = :parentId")
    List<CommentEntity> findChildCommentsByParentId(@Param("parentId") Long parentId);

    @Query("SELECT COUNT(cc) FROM CommentClosureEntity cc WHERE cc.parentComment.id = :parentId")
    int countRepliesByParentId(@Param("parentId") Long parentId);
}
