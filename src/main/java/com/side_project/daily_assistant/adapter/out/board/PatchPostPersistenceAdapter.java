package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.application.port.out.board.PatchPostPort;
import com.side_project.daily_assistant.domain.board.Post;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@DynamicUpdate
public class PatchPostPersistenceAdapter implements PatchPostPort {

    private final PostRepository postRepository;

    @Override
    public String patchPost(Long id, ModifyPostReq modifyPostReq) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );

        Post post = Post.fromEntity(postEntity);
        post.updatedPostInfo(modifyPostReq);
        postRepository.save(post.toEntity(post));
        return "게시글이 수정되었습니다";
    }
}
