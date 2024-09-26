package com.side_project.daily_assistant.adapter.out.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByPostId(Long postId);

    // 최상위 댓글 조회 (parentComment가 없는 댓글)
    @Query("SELECT c FROM CommentEntity c WHERE c.post.id = :postId AND c.id NOT IN (SELECT cc.childComment.id FROM CommentClosureEntity cc)")
    List<CommentEntity> findTopLevelCommentsByPostId(@Param("postId") Long postId);

    // 특정 parentId에 해당하는 하위 댓글 조회
    @Query("SELECT cc.childComment FROM CommentClosureEntity cc WHERE cc.parentComment.id = :parentId")
    List<CommentEntity> findChildCommentsByParentId(@Param("parentId") Long parentId);

    // 특정 parentId에 해당하는 하위 댓글 개수 조회
    @Query("SELECT COUNT(cc) FROM CommentClosureEntity cc WHERE cc.parentComment.id = :parentId")
    int countRepliesByParentId(@Param("parentId") Long parentId);

//    Optional<CommentEntity> findByParentId(Long parentId);
}
