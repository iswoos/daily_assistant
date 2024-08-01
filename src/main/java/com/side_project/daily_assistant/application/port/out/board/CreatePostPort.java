package com.side_project.daily_assistant.application.port.out.board;

import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;

public interface CreatePostPort {
    String createPost(CreatePostReq createPost);
}
