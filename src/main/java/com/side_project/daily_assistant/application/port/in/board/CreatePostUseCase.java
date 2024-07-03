package com.side_project.daily_assistant.application.port.in.board;

import com.side_project.daily_assistant.adapter.in.board.PostController;

public interface CreatePostUseCase {
    void createPost(PostController.CreatePost createPost);
}
