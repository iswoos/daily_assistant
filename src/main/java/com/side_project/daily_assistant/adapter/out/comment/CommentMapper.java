package com.side_project.daily_assistant.adapter.out.comment;

import com.side_project.daily_assistant.dto.responsedto.comment.GetCommentRes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    List<GetCommentRes> toListGetCommentRes(List<CommentEntity> commentEntityList);
}