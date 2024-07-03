package com.side_project.daily_assistant.dto.requestdto.board;

public record CreatePostReq(
        String title,
        String content,
        String userId
) { }
