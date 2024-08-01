package com.side_project.daily_assistant.application.port.in.board;

import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;

public interface CreatePostUseCase {
    String createPost(CreatePostReq createPost);
}
