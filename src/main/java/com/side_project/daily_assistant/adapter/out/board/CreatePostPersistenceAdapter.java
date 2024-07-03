package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.adapter.in.board.PostController;
import com.side_project.daily_assistant.application.port.out.board.CreatePostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostPersistenceAdapter implements CreatePostPort {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public void createPost(PostController.CreatePost createPost) {
        PostEntity postEntity = postMapper.toEntity(createPost);
        postRepository.save(postEntity);
    }
}
