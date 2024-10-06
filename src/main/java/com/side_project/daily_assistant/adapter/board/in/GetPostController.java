package com.side_project.daily_assistant.adapter.board.in;

import com.side_project.daily_assistant.application.port.board.in.GetPostUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetPostController {

    private final GetPostUseCase getPostUseCase;

    // 게시글 단건조회
    @GetMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<GetPostRes>> getPost(@PathVariable Long postId) {
        ApiResponse<GetPostRes> response = ApiResponse.ok(getPostUseCase.getPost(postId));
        return ApiResponse.toResponseEntity(response);
    }
}
