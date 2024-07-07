package com.side_project.daily_assistant.dto.responsedto.board;

import java.time.LocalDateTime;

public record GetPostRes(
        Long id,
        String title,
        String content,
        String image,
        String category,
        String userId,
        LocalDateTime createdDateTime,
        Long view_count,
        Long likes_count
) { }
