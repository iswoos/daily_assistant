package com.side_project.daily_assistant.service.board;

import com.side_project.daily_assistant.application.port.in.board.GetPostListUseCase;
import com.side_project.daily_assistant.application.port.out.board.GetPostListPort;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPostListService implements GetPostListUseCase {

    private final GetPostListPort getPostListPort;

    @Override
    public List<GetPostRes> getPostList() {
        return getPostListPort.getPostList();
    }
}
