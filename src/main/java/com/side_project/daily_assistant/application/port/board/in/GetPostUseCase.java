package com.side_project.daily_assistant.application.port.board.in;

import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

public interface GetPostUseCase {
    GetPostRes getPost(Long id);
}
