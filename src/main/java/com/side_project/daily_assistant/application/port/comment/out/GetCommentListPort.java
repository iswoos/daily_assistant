package com.side_project.daily_assistant.application.port.comment.out;

import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import com.side_project.daily_assistant.dto.responsedto.comment.GetCommentRes;

import java.util.List;

public interface GetCommentListPort {
    List<GetCommentRes> getCommentList(Long postId);

    List<GetCommentRes> getChildCommentList(Long parentId);
}
