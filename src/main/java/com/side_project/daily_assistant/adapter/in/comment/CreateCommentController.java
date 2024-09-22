package com.side_project.daily_assistant.adapter.in.comment;

import com.side_project.daily_assistant.application.port.in.comment.CreateCommentUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.requestdto.comment.CreateCommentReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateCommentController {

    private final CreateCommentUseCase createCommentUseCase;

    // 댓글 작성
    @PostMapping("/comments/{postId}")
    public ResponseEntity<ApiResponse<String>> createComments(@PathVariable Long postId, @RequestBody CreateCommentReq createCommentReq) {
        ApiResponse<String> response = ApiResponse.ok(createCommentUseCase.createComment(postId, createCommentReq));
        return ApiResponse.toResponseEntity(response);
    }
}
