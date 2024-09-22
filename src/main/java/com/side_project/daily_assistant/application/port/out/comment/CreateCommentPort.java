package com.side_project.daily_assistant.application.port.out.comment;

import com.side_project.daily_assistant.dto.requestdto.comment.CreateCommentReq;

public interface CreateCommentPort {
    String createComment(Long postId, CreateCommentReq createCommentReq);
}
