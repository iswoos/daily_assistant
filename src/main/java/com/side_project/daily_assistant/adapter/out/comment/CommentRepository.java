package com.side_project.daily_assistant.adapter.out.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByPostId(Long postId);

    Optional<CommentEntity> findByParentId(Long parentId);
}
