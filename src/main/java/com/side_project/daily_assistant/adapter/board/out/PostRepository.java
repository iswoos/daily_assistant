package com.side_project.daily_assistant.adapter.board.out;

import com.side_project.daily_assistant.adapter.common.isDeleted;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    Page<PostEntity> findAllByIsDeleted(isDeleted isDeleted, Pageable pageable);
}
