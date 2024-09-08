package com.side_project.daily_assistant.adapter.in.board;

import com.side_project.daily_assistant.application.port.in.board.LikePostUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikePostController {

    private final LikePostUseCase likePostUseCase;

    // 게시글 추천
    @PatchMapping("/posts/{postId}/likes")
    public ResponseEntity<ApiResponse<String>> likePost(@PathVariable Long postId) {
        ApiResponse<String> response = ApiResponse.ok(likePostUseCase.likePost(postId));
        return ApiResponse.toResponseEntity(response);
    }
}
