package com.side_project.daily_assistant.dto.requestdto.board;

import java.util.List;

public record ModifyPostReq(
        String title,
        String content,
        List<String> imageUrls,
        String postCategory
) { }
