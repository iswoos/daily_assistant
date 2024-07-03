package com.side_project.daily_assistant.service.board;

import com.side_project.daily_assistant.adapter.in.board.PostController;
import com.side_project.daily_assistant.application.port.in.board.CreatePostUseCase;
import com.side_project.daily_assistant.application.port.out.board.CreatePostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreatePostService implements CreatePostUseCase {

    private final CreatePostPort createPostPort;

    @Override
    public void createPost(PostController.CreatePost createPost) {
        createPostPort.createPost(createPost);
    }
}
