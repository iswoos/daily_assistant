package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.application.port.out.board.PatchPostPort;
import com.side_project.daily_assistant.domain.board.Post;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
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
    private final PostMapper postMapper;

    @Override
    public void patchPost(Long id, ModifyPostReq modifyPostReq) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        Post post = postMapper.toDomain(postEntity);
        post.updatedPostInfo(modifyPostReq);
        postEntity = postMapper.toEntity(post);
        postRepository.save(postEntity);
    }
}
