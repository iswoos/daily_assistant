package com.side_project.daily_assistant.dto.responsedto.board;

import com.side_project.daily_assistant.adapter.out.board.PostEntity;
import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import lombok.Builder;

import java.time.LocalDateTime;

public record GetPostRes(
        Long id,
        String title,
        String content,
        String image,
        String boardCategory,
        String postCategory,
        String userId,
        LocalDateTime createdDateTime,
        Long viewCount,
        Long likesCount
) {
    @Builder
    public GetPostRes(
            Long id,
            String title,
            String content,
            String image,
            String boardCategory,
            String postCategory,
            String userId,
            LocalDateTime createdDateTime,
            Long viewCount,
            Long likesCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.boardCategory = boardCategory;
        this.postCategory = postCategory;
        this.userId = userId;
        this.createdDateTime = createdDateTime;
        this.viewCount = viewCount;
        this.likesCount = likesCount;
    }

    public static GetPostRes fromEntity(PostEntity postEntity) {
        return GetPostRes.builder()
                .id(postEntity.getId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .image(postEntity.getImage())
                .boardCategory(postEntity.getBoardCategory())
                .postCategory(postEntity.getPostCategory())
                .userId(postEntity.getUserId())
                .createdDateTime(postEntity.getCreatedDateTime())
                .viewCount(postEntity.getViewCount())
                .likesCount(postEntity.getLikesCount())
                .build();
    }
}
