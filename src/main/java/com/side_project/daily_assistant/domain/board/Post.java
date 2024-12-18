package com.side_project.daily_assistant.domain.board;

import com.side_project.daily_assistant.adapter.board.out.PostEntity;
import com.side_project.daily_assistant.adapter.common.isDeleted;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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

    private String imageFolderUUID;

    private List<String> imageUrls;

    private String postCategory;

    private Long viewCount;

    private Long likesCount;

    private LocalDateTime createdDateTime;

    private LocalDateTime modifiedDateTime;

    @Enumerated(EnumType.STRING)
    private isDeleted isDeleted;

    public static Post fromEntity(PostEntity postEntity) {
        return Post.builder()
                .id(postEntity.getId())
                .boardCategory(postEntity.getBoardCategory())
                .userId(postEntity.getUserId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .imageFolderUUID(postEntity.getImageFolderUUID())
                .imageUrls(postEntity.getImageUrls())
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
                .imageFolderUUID(post.getImageFolderUUID())
                .imageUrls(post.getImageUrls())
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

    public void updatedPostInfo(ModifyPostReq modifyPostReq, List<String> images) {
        setPostInfo(modifyPostReq, images);
    }

    private void setPostInfo(ModifyPostReq modifyPostReq, List<String> images) {
        this.title = modifyPostReq.title();
        this.content = modifyPostReq.content();
        this.imageUrls = images;
        this.postCategory = modifyPostReq.postCategory();
    }
}