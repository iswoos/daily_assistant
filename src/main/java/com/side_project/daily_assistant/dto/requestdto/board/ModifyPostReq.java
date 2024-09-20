package com.side_project.daily_assistant.dto.requestdto.board;

public record ModifyPostReq(
        String title,
        String content,
        String postCategory
) { }
