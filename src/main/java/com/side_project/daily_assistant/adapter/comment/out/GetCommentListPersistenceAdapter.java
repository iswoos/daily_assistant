package com.side_project.daily_assistant.adapter.comment.out;

import com.side_project.daily_assistant.application.port.comment.out.GetCommentListPort;
import com.side_project.daily_assistant.dto.responsedto.comment.GetCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GetCommentListPersistenceAdapter implements GetCommentListPort {

    private final CommentRepository commentRepository;

    @Override
    public List<GetCommentRes> getCommentList(Long postId) {
        List<CommentEntity> commentList = commentRepository.findTopLevelCommentsByPostId(postId);
        return commentList.stream()
                .map(comment -> {
                    int replyCount = commentRepository.countRepliesByParentId(comment.getId());
                    return GetCommentRes.fromEntity(comment, replyCount);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<GetCommentRes> getChildCommentList(Long parentId) {
        List<CommentEntity> commentList = commentRepository.findChildCommentsByParentId(parentId);
        return commentList.stream()
                .map(comment -> {
                    int replyCount = commentRepository.countRepliesByParentId(comment.getId());
                    return GetCommentRes.fromEntity(comment, replyCount);
                })
                .collect(Collectors.toList());
    }
}
