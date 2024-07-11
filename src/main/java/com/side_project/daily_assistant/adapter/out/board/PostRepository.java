package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findAllByIsDeleted(isDeleted isDeleted);
}
