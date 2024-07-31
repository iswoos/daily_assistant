package com.side_project.daily_assistant.dto.responsedto.comment;

import java.time.LocalDateTime;
import java.util.List;

public record GetCommentRes(
        Long id,
        Long parent,
        List<GetCommentRes> replies,
        String userId,
        String content,
        LocalDateTime createdDateTime
) { }
