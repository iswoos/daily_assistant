package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.application.port.out.board.CreatePostPort;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostPersistenceAdapter implements CreatePostPort {

    private final PostRepository postRepository;

    @Override
    public String createPost(CreatePostReq createPost) {
        PostEntity postEntity = PostEntity.create(createPost);
        postRepository.save(postEntity);
        return "게시글이 등록되었습니다";
    }
}
