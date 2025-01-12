package com.side_project.daily_assistant.service.board;

import com.side_project.daily_assistant.application.port.board.in.GetPostListUseCase;
import com.side_project.daily_assistant.application.port.board.out.GetPostListPort;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPostListService implements GetPostListUseCase {

    private final GetPostListPort getPostListPort;

    @Override
    public List<GetPostRes> getPostList(Pageable pageable) {
        return getPostListPort.getPostList(pageable);
    }
}
