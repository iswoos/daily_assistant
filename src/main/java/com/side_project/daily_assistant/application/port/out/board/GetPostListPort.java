package com.side_project.daily_assistant.application.port.out.board;

import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface GetPostListPort {
    List<GetPostRes> getPostList(Pageable pageable);
}
