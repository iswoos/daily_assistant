package com.side_project.daily_assistant.application.port.out.board;

import com.side_project.daily_assistant.adapter.in.board.PostController;

public interface CreatePostPort {
    void createPost(PostController.CreatePost createPost);
}
