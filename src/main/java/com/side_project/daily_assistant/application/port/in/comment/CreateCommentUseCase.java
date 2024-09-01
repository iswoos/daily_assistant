package com.side_project.daily_assistant.application.port.in.comment;

import com.side_project.daily_assistant.dto.requestdto.comment.CreateCommentReq;

public interface CreateCommentUseCase {
    String createComment(CreateCommentReq createCommentReq);
}
