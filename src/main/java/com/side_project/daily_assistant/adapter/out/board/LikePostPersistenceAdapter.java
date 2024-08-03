package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.application.port.out.board.LikePostPort;
import com.side_project.daily_assistant.domain.board.Post;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
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
    public String likePost(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );

        Post post = postMapper.toDomain(postEntity);
        post.likesCountUp();
        postRepository.save(postMapper.toEntity(post));
        return "게시글이 추천이 완료되었습니다";
    }
}
