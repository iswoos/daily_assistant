package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.domain.board.Post;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toDomain(PostEntity postEntity);

    PostEntity toEntity(Post domain);

    PostEntity toEntity(CreatePostReq createPost);

    GetPostRes toGetPostRes(PostEntity postEntity);
}
