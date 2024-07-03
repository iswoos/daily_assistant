package com.side_project.daily_assistant.service.board;

import com.side_project.daily_assistant.application.port.in.board.GetPostUseCase;
import com.side_project.daily_assistant.application.port.out.board.GetPostPort;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetPostService implements GetPostUseCase {

    private final GetPostPort getPostPort;

    @Override
    public GetPostRes getPost(Long id) {
        return getPostPort.getPost(id);
    }
}
