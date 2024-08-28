package com.side_project.daily_assistant.adapter.out.comment;

import com.side_project.daily_assistant.application.port.out.comment.GetCommentListPort;
import com.side_project.daily_assistant.dto.responsedto.comment.GetCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GetCommentListPersistenceAdapter implements GetCommentListPort {

    private final CommentRepository commentRepository;

    @Override
    public List<GetCommentRes> getCommentList(Long id) {
        List<CommentEntity> commentList = commentRepository.findAllByPostId(id);
        return commentList.stream()
                .map(GetCommentRes::)
    }
}
