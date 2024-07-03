package com.side_project.daily_assistant.domain.board;

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
}