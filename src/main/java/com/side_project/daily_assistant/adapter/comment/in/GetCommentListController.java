package com.side_project.daily_assistant.adapter.comment.in;

import com.side_project.daily_assistant.application.port.comment.in.GetCommentListUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.responsedto.comment.GetCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetCommentListController {

    private final GetCommentListUseCase getCommentListUseCase;

    // 최초 댓글 조회
    @GetMapping("/comments/{postId}")
    public ResponseEntity<ApiResponse<List<GetCommentRes>>> getCommentList(@PathVariable Long postId) {
        ApiResponse<List<GetCommentRes>> response = ApiResponse.ok(getCommentListUseCase.getCommentList(postId));
        return ApiResponse.toResponseEntity(response);
    }

    // 부모 댓글 하위내역 조회
    @GetMapping("/comments/{postId}/{parentId}")
    public ResponseEntity<ApiResponse<List<GetCommentRes>>> getChildCommentList(@PathVariable Long postId, @PathVariable Long parentId) {
        ApiResponse<List<GetCommentRes>> response = ApiResponse.ok(getCommentListUseCase.getChildCommentList(parentId));
        return ApiResponse.toResponseEntity(response);
    }
}
