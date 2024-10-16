package com.side_project.daily_assistant.service.board;

import com.side_project.daily_assistant.application.port.board.in.LikePostUseCase;
import com.side_project.daily_assistant.application.port.board.out.LikePostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikePostService implements LikePostUseCase {

    private final LikePostPort likePostPort;

    @Override
    public String likePost(Long id) {
        return likePostPort.likePost(id);
    }
}
