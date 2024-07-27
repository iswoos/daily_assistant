package com.side_project.daily_assistant.dto.responsedto.comment;

import com.side_project.daily_assistant.adapter.out.comment.CommentEntity;

import java.time.LocalDateTime;
import java.util.List;

public record GetCommentRes(
        Long id,
        CommentEntity parent,
        List<CommentEntity> replies,
        String userId,
        String content,
        LocalDateTime modifiedDateTime
) { }
