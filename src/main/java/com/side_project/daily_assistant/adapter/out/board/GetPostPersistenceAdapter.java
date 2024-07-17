package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.application.port.out.board.GetPostPort;
import com.side_project.daily_assistant.domain.board.Post;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetPostPersistenceAdapter implements GetPostPort {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public GetPostRes getPost(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );

        Post post = postMapper.toDomain(postEntity);
        post.viewCountUp();

        postEntity = postMapper.toEntity(post);
        postRepository.save(postEntity);

        return postMapper.toGetPostRes(postEntity);
    }
}
