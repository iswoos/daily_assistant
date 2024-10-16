package com.side_project.daily_assistant.application.port.comment.in;

import com.side_project.daily_assistant.dto.requestdto.comment.CreateCommentReq;

public interface CreateCommentUseCase {
    String createComment(Long postId, CreateCommentReq createCommentReq);
}
