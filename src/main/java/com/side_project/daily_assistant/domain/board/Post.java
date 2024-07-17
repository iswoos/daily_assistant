package com.side_project.daily_assistant.domain.board;

import com.side_project.daily_assistant.adapter.out.common.isDeleted;
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

    @Enumerated(EnumType.STRING)
    private isDeleted isDeleted;

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