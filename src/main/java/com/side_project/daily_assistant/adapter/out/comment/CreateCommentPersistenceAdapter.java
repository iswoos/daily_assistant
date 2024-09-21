package com.side_project.daily_assistant.adapter.out.comment;

import com.side_project.daily_assistant.adapter.out.board.PostEntity;
import com.side_project.daily_assistant.adapter.out.board.PostRepository;
import com.side_project.daily_assistant.application.port.out.comment.CreateCommentPort;
import com.side_project.daily_assistant.dto.requestdto.comment.CreateCommentReq;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCommentPersistenceAdapter implements CreateCommentPort {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Override
    public String createComment(Long postId, CreateCommentReq createCommentReq) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );

        CommentEntity parent = null;
        if (createCommentReq.parentId() != null) {
            parent = commentRepository.findById(createCommentReq.parentId()).orElseThrow(
                    () -> new CustomException(ErrorCode.COMMENT_NOT_FOUND)
            );

            if (parent.getPost().getId() != postId) {
                new CustomException(ErrorCode.PARENT_COMMENT_MISMATCH);
            }
        }

        CommentEntity createComment = CommentEntity.craete(createCommentReq, postEntity, parent);
        commentRepository.save(createComment);
        return "댓글이 등록되었습니다";
    }
}
