package com.side_project.daily_assistant.application.port.comment.in;

import com.side_project.daily_assistant.dto.responsedto.comment.GetCommentRes;

import java.util.List;

public interface GetCommentListUseCase {
    List<GetCommentRes> getCommentList(Long postId);

    List<GetCommentRes> getChildCommentList(Long parentId);
}
