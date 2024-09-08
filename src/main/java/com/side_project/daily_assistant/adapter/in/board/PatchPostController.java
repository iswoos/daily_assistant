package com.side_project.daily_assistant.adapter.in.board;

import com.side_project.daily_assistant.application.port.in.board.PatchPostUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PatchPostController {

    private final PatchPostUseCase patchPostUseCase;

    // 게시글 수정
    @PatchMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse<String>> patchPost(@PathVariable Long postId, @RequestBody ModifyPostReq modifyPost) {
        ApiResponse<String> response = ApiResponse.ok(patchPostUseCase.patchPost(postId, modifyPost));
        return ApiResponse.toResponseEntity(response);
    }
}
