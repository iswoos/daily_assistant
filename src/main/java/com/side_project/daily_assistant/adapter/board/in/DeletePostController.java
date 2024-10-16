package com.side_project.daily_assistant.adapter.board.in;

import com.side_project.daily_assistant.application.port.board.in.DeletePostUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeletePostController {

    private final DeletePostUseCase deletePostUseCase;

    // 게시글 삭제
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<String>> deletePost(@PathVariable Long postId) {
        ApiResponse<String> response = ApiResponse.ok(deletePostUseCase.deletePost(postId));
        return ApiResponse.toResponseEntity(response);
    }
}
