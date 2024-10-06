package com.side_project.daily_assistant.adapter.board.out;

import com.side_project.daily_assistant.application.port.board.out.CreatePostPort;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreatePostPersistenceAdapter implements CreatePostPort {

    private final PostRepository postRepository;

    @Override
    public GetPostRes createPost(CreatePostReq createPost, String imageFolderUUID, List<String> prePutSignedUrls, List<String> getImageUrls) {
        PostEntity postEntity = PostEntity.create(createPost, imageFolderUUID, getImageUrls);
        postRepository.save(postEntity);
        return GetPostRes.fromEntity(postEntity, prePutSignedUrls);
    }
}
