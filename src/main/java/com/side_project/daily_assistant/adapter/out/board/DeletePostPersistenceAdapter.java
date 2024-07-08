package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import com.side_project.daily_assistant.application.port.out.board.DeletePostPort;
import com.side_project.daily_assistant.domain.board.Post;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@DynamicUpdate
public class DeletePostPersistenceAdapter implements DeletePostPort {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public void deletePost(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );

        Post post = postMapper.toDomain(postEntity);
        post.deleted(isDeleted.Y);

        postMapper.toEntity(post);
    }
}
