package com.side_project.daily_assistant.dto.requestdto.comment;

public record CreateCommentReq(
        String userId,
        String content,
        Long parentId
) { }
