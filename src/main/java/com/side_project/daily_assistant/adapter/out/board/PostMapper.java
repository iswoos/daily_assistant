package com.side_project.daily_assistant.adapter.out.board;

import com.side_project.daily_assistant.adapter.in.board.PostController;
import com.side_project.daily_assistant.domain.board.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toDomain(PostEntity postEntity);

    PostEntity toEntity(Post domain);

    PostEntity toEntity(PostController.CreatePost createPost);
}
