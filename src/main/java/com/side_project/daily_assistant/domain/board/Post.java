package com.side_project.daily_assistant.domain.board;

import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Post {
    private Long id;

    private String userId;

    private String title;

    private String content;

    private String board_category;

    private String image;

    private String post_category;

    private Long view_count;

    private Long likes_count;

    @Enumerated(EnumType.STRING)
    private isDeleted is_deleted;

    public void deleted(isDeleted is_deleted) {
        setDeleted(is_deleted);
    }

    private void setDeleted(isDeleted is_deleted) {
        this.is_deleted = is_deleted;
    }
}