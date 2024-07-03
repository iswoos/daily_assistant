package com.side_project.daily_assistant.application.port.in.board;

import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

public interface GetPostUseCase {
    GetPostRes getPost(Long id);
}
