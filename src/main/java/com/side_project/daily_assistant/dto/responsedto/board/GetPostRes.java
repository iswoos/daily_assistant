package com.side_project.daily_assistant.dto.responsedto.board;

public record GetPostRes(
        String title,
        String content,
        String userId
) { }
