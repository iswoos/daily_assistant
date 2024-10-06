package com.side_project.daily_assistant.dto.responsedto.board;

import com.side_project.daily_assistant.adapter.board.out.PostEntity;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public record GetPostRes(
        Long id,
        String title,
        String content,
        String imageFolderUUID,
        List<String> imageUrls,
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
            String imageFolderUUID,
            List<String> imageUrls,
            String boardCategory,
            String postCategory,
            String userId,
            LocalDateTime createdDateTime,
            Long viewCount,
            Long likesCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageFolderUUID = imageFolderUUID;
        this.imageUrls = imageUrls;
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
                .imageFolderUUID(postEntity.getImageFolderUUID())
                .imageUrls(postEntity.getImageUrls())
                .boardCategory(postEntity.getBoardCategory())
                .postCategory(postEntity.getPostCategory())
                .userId(postEntity.getUserId())
                .createdDateTime(postEntity.getCreatedDateTime())
                .viewCount(postEntity.getViewCount())
                .likesCount(postEntity.getLikesCount())
                .build();
    }

    public static GetPostRes fromEntity(PostEntity postEntity, List<String> prePutSignedUrls) {
        return GetPostRes.builder()
                .id(postEntity.getId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .imageFolderUUID(postEntity.getImageFolderUUID())
                .imageUrls(prePutSignedUrls)
                .boardCategory(postEntity.getBoardCategory())
                .postCategory(postEntity.getPostCategory())
                .userId(postEntity.getUserId())
                .createdDateTime(postEntity.getCreatedDateTime())
                .viewCount(postEntity.getViewCount())
                .likesCount(postEntity.getLikesCount())
                .build();
    }
}
