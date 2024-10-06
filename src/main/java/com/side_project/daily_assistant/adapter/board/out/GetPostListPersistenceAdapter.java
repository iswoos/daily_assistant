package com.side_project.daily_assistant.adapter.board.out;

import com.side_project.daily_assistant.adapter.common.isDeleted;
import com.side_project.daily_assistant.application.port.board.out.GetPostListPort;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetPostListPersistenceAdapter implements GetPostListPort {

    private final PostRepository postRepository;

    @Override
    public List<GetPostRes> getPostList(Pageable pageable) {
        List<PostEntity> postEntityList = postRepository.findAllByIsDeleted(isDeleted.N, pageable);
        return postEntityList.stream()
                .map(GetPostRes::fromEntity)
                .collect(Collectors.toList());
    }
}
