package com.side_project.daily_assistant.application.port.in.board;

import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

import java.util.List;

public interface GetPostListUseCase {
    List<GetPostRes> getPostList();
}
