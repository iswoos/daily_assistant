package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.application.port.out.board.LikePostPort;
import com.side_project.daily_assistant.domain.board.Post;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@DynamicUpdate
public class LikePostPersistenceAdapter implements LikePostPort {

    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Override
    public void likePost(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );

        Post post = postMapper.toDomain(postEntity);
        post.likesCountUp();
        postRepository.save(postMapper.toEntity(post));
    }
}
