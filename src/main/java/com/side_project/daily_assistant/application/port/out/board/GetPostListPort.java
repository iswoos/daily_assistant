package com.side_project.daily_assistant.application.port.out.board;

import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

import java.util.List;

public interface GetPostListPort {
    List<GetPostRes> getPostList();
}
