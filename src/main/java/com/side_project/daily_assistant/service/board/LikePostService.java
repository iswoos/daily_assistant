package com.side_project.daily_assistant.service.board;

import com.side_project.daily_assistant.application.port.in.board.LikePostUseCase;
import com.side_project.daily_assistant.application.port.out.board.LikePostPort;
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
