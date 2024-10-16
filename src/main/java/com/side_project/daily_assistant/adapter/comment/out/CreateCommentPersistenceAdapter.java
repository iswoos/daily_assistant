package com.side_project.daily_assistant.adapter.comment.out;

import com.side_project.daily_assistant.adapter.board.out.PostEntity;
import com.side_project.daily_assistant.adapter.board.out.PostRepository;
import com.side_project.daily_assistant.application.port.comment.out.CreateCommentPort;
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
    private final CommentClosureRepository commentClosureRepository;

    @Override
    public String createComment(Long postId, CreateCommentReq createCommentReq) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );

        CommentEntity parent = null;
        int depth = 0;
        if (createCommentReq.parentId() != null) {
            parent = commentRepository.findById(createCommentReq.parentId()).orElseThrow(
                    () -> new CustomException(ErrorCode.COMMENT_NOT_FOUND)
            );

            if (!parent.getPost().getId().equals(postId)) {
                throw new CustomException(ErrorCode.PARENT_COMMENT_MISMATCH);
            }

            depth = commentClosureRepository.findDepthByParentCommentId(createCommentReq.parentId())
                    .map(d -> d + 1)
                    .orElse(0);
        }

        CommentEntity createComment = CommentEntity.create(createCommentReq, postEntity);
        commentRepository.save(createComment);

        CommentClosureEntity commentClosureEntity = CommentClosureEntity.create(parent, createComment, depth);
        commentClosureRepository.save(commentClosureEntity);

        return "댓글이 등록되었습니다";
    }
}
