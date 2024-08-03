package com.side_project.daily_assistant.service.board;

import com.side_project.daily_assistant.application.port.in.board.DeletePostUseCase;
import com.side_project.daily_assistant.application.port.out.board.DeletePostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostService implements DeletePostUseCase {

    private final DeletePostPort deletePostPort;

    @Override
    public String deletePost(Long id) {
        return deletePostPort.deletePost(id);
    }
}
