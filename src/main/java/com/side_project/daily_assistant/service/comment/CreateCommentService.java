package com.side_project.daily_assistant.service.comment;

import com.side_project.daily_assistant.application.port.in.comment.CreateCommentUseCase;
import com.side_project.daily_assistant.application.port.out.comment.CreateCommentPort;
import com.side_project.daily_assistant.dto.requestdto.comment.CreateCommentReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateCommentService implements CreateCommentUseCase {

    private final CreateCommentPort createCommentPort;

    @Override
    public String createComment(CreateCommentReq createCommentReq) {
        return createCommentPort.createComment(createCommentReq);
    }
}
