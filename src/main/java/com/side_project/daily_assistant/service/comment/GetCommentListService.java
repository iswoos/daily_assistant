package com.side_project.daily_assistant.service.comment;

import com.side_project.daily_assistant.application.port.comment.in.GetCommentListUseCase;
import com.side_project.daily_assistant.application.port.comment.out.GetCommentListPort;
import com.side_project.daily_assistant.dto.responsedto.comment.GetCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCommentListService implements GetCommentListUseCase {

    private final GetCommentListPort getCommentListPort;

    @Override
    public List<GetCommentRes> getCommentList(Long postId) {
        return getCommentListPort.getCommentList(postId);
    }

    @Override
    public List<GetCommentRes> getChildCommentList(Long parentId) {
        return getCommentListPort.getChildCommentList(parentId);
    }
}
