package com.side_project.daily_assistant.dto.responsedto.comment;

import com.side_project.daily_assistant.adapter.out.comment.CommentEntity;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public record GetCommentRes(
        Long id,
        String userId,
        String content,
        LocalDateTime createdDateTime
) {

    @Builder
    public GetCommentRes(
            Long id,
            String userId,
            String content,
            LocalDateTime createdDateTime) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.createdDateTime = createdDateTime;
    }

    public static GetCommentRes fromEntity(CommentEntity commentEntity) {
        return GetCommentRes.builder()
                .id(commentEntity.getId())
                .userId(commentEntity.getUserId())
                .content(commentEntity.getContent())
                .createdDateTime(commentEntity.getCreatedDateTime())
                .build();
    }


}
