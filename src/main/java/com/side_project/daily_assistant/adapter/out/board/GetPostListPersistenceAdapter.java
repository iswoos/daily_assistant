package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import com.side_project.daily_assistant.application.port.out.board.GetPostListPort;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPostListPersistenceAdapter implements GetPostListPort {

    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Override
    public List<GetPostRes> getPostList() {
        List<PostEntity> postList = postRepository.findAllByIsDeleted(isDeleted.N);
        return postMapper.toListGetPostRes(postList);
    }
}
