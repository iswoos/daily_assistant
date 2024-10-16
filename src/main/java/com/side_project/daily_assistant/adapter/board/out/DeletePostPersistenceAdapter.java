package com.side_project.daily_assistant.adapter.board.out;

import com.side_project.daily_assistant.adapter.common.isDeleted;
import com.side_project.daily_assistant.application.port.board.out.DeletePostPort;
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

    @Override
    public String deletePost(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );

        Post post = Post.fromEntity(postEntity);
        post.deleted(isDeleted.Y);
        postRepository.save(post.toEntity(post));
        return "게시글이 삭제되었습니다";
    }
}
