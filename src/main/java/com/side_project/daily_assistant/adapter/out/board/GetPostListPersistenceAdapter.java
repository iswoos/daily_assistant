package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import com.side_project.daily_assistant.application.port.out.board.GetPostListPort;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetPostListPersistenceAdapter implements GetPostListPort {

    private final PostRepository postRepository;

    @Override
    public List<GetPostRes> getPostList() {
        List<PostEntity> postEntityList = postRepository.findAllByIsDeleted(isDeleted.N);
        return postEntityList.stream()
                .map(GetPostRes::fromEntity)
                .collect(Collectors.toList());
    }
}
