package com.side_project.daily_assistant.adapter.in.board;

import com.side_project.daily_assistant.application.port.in.board.GetPostListUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetPostListController {

    private final GetPostListUseCase getPostListUseCase;

    // 게시글 전체조회
    @GetMapping("/posts")
    public ResponseEntity<ApiResponse<List<GetPostRes>>> getPostList(){
        ApiResponse<List<GetPostRes>> response = ApiResponse.ok(getPostListUseCase.getPostList());
        return ApiResponse.toResponseEntity(response);
    }
}
