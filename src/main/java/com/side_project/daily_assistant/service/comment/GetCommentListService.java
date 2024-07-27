package com.side_project.daily_assistant.service.comment;

import com.side_project.daily_assistant.application.port.in.comment.GetCommentListUseCase;
import com.side_project.daily_assistant.application.port.out.comment.GetCommentListPort;
import com.side_project.daily_assistant.dto.responsedto.comment.GetCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCommentListService implements GetCommentListUseCase {

    private final GetCommentListPort getCommentListPort;

    @Override
    public List<GetCommentRes> getCommentList(Long id) {
        return getCommentListPort.getCommentList(id);
    }
}
