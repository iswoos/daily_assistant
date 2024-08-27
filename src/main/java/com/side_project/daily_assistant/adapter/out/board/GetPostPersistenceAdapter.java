package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.application.port.out.board.GetPostPort;
import com.side_project.daily_assistant.domain.board.Post;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GetPostPersistenceAdapter implements GetPostPort {

    private final PostRepository postRepository;

    @Override
    public GetPostRes getPost(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );

        Post post = Post.fromEntity(postEntity);
        post.viewCountUp();
        PostEntity updatePostEntity = post.toEntity(post);
        postRepository.save(updatePostEntity);

        return GetPostRes.fromEntity(updatePostEntity);
    }
}
