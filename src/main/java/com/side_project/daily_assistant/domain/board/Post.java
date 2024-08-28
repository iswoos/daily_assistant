package com.side_project.daily_assistant.domain.board;

import com.side_project.daily_assistant.adapter.out.board.PostEntity;
import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Post {
    private Long id;

    private String userId;

    private String title;

    private String content;

    private String boardCategory;

    private String image;

    private String postCategory;

    private Long viewCount;

    private Long likesCount;

    private LocalDateTime createdDateTime;

    private LocalDateTime modifiedDateTime;

    @Enumerated(EnumType.STRING)
    private isDeleted isDeleted;

    @Builder
    private Post(
            Long id,
            String boardCategory,
            String userId,
            String title,
            String content,
            String image,
            String postCategory,
            Long viewCount,
            Long likesCount,
            isDeleted isDeleted,
            LocalDateTime createdDateTime,
            LocalDateTime modifiedDateTime) {
        this.id = id;
        this.boardCategory = boardCategory;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.image = image;
        this.postCategory = postCategory;
        this.viewCount = viewCount;
        this.likesCount = likesCount;
        this.isDeleted = isDeleted;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public static Post fromEntity(PostEntity postEntity) {
        return Post.builder()
                .id(postEntity.getId())
                .boardCategory(postEntity.getBoardCategory())
                .userId(postEntity.getUserId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .image(postEntity.getImage())
                .postCategory(postEntity.getPostCategory())
                .viewCount(postEntity.getViewCount())
                .likesCount(postEntity.getLikesCount())
                .isDeleted(postEntity.getIsDeleted())
                .createdDateTime(postEntity.getCreatedDateTime())
                .modifiedDateTime(postEntity.getModifiedDateTime())
                .build();
    }

    public static PostEntity toEntity(Post post) {
        return PostEntity.builder()
                .id(post.getId())
                .boardCategory(post.getBoardCategory())
                .userId(post.getUserId())
                .title(post.getTitle())
                .content(post.getContent())
                .image(post.getImage())
                .postCategory(post.getPostCategory())
                .viewCount(post.getViewCount())
                .likesCount(post.getLikesCount())
                .isDeleted(post.getIsDeleted())
                .createdDateTime(post.getCreatedDateTime())
                .modifiedDateTime(LocalDateTime.now())
                .build();
    }

    public void deleted(isDeleted is_deleted) {
        setDeleted(is_deleted);
    }

    private void setDeleted(isDeleted isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void viewCountUp() {
        setViewCountUP();
    }

    private void setViewCountUP() {
        this.viewCount++;
    }

    public void likesCountUp() {
        setLikesCountUP();
    }

    private void setLikesCountUP() {
        this.likesCount++;
    }

    public void updatedPostInfo(ModifyPostReq modifyPostReq) {
        setPostInfo(modifyPostReq);
    }

    private void setPostInfo(ModifyPostReq modifyPostReq) {
        this.title = modifyPostReq.title();
        this.content = modifyPostReq.content();
        this.image = modifyPostReq.image();
        this.postCategory = modifyPostReq.postCategory();
    }
}