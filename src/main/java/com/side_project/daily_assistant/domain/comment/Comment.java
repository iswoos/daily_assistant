package com.side_project.daily_assistant.domain.comment;

import com.side_project.daily_assistant.adapter.common.isDeleted;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Comment {
    private Long id;

    private Long post;

    private Comment parent;

    private List<Comment> replies;

    private String userId;

    private String content;

    @Enumerated(EnumType.STRING)
    private isDeleted isDeleted;
}
