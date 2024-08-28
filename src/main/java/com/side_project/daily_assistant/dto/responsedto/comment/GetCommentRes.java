package com.side_project.daily_assistant.dto.responsedto.comment;

import com.side_project.daily_assistant.adapter.out.board.PostEntity;
import com.side_project.daily_assistant.adapter.out.comment.CommentEntity;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public record GetCommentRes(
        Long id,
        Long parent,
        List<GetCommentRes> replies,
        String userId,
        String content,
        LocalDateTime createdDateTime
) {

    @Builder
    public GetCommentRes(
            Long id,
            Long parent,
            List<GetCommentRes> replies,
            String userId,
            String content,
            LocalDateTime createdDateTime) {
        this.id = id;
        this.parent = parent;
        this.replies = replies;
        this.userId = userId;
        this.content = content;
        this.createdDateTime = createdDateTime;
    }

    public static GetCommentRes fromEntity(CommentEntity commentEntity) {
        return GetCommentRes.builder()
                .id(commentEntity.getId())
                .parent(commentEntity.getParent())
                .content(commentEntity.getContent())
                .image(commentEntity.getImage())
                .boardCategory(postEntity.getBoardCategory())
                .postCategory(postEntity.getPostCategory())
                .userId(postEntity.getUserId())
                .createdDateTime(postEntity.getCreatedDateTime())
                .viewCount(postEntity.getViewCount())
                .likesCount(postEntity.getLikesCount())
                .build();
    }


}
