package com.side_project.daily_assistant.application.port.out.board;

import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

public interface GetPostPort {
    GetPostRes getPost(Long id);
}
