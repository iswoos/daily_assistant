package com.side_project.daily_assistant.adapter.in.board;

import com.side_project.daily_assistant.application.port.in.board.*;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final CreatePostUseCase createPostUseCase;
    private final GetPostUseCase getPostUseCase;
    private final GetPostListUseCase getPostListUseCase;
    private final PatchPostUseCase patchPostUseCase;
    private final DeletePostUseCase deletePostUseCase;
    private final LikePostUseCase likePostUseCase;

    // 게시글 전체조회
    @GetMapping("/posts")
    public ResponseEntity<ApiResponse<List<GetPostRes>>> getPostList(){
        ApiResponse<List<GetPostRes>> response = ApiResponse.ok(getPostListUseCase.getPostList());
        return ApiResponse.toResponseEntity(response);
    }

    // 게시글 단건조회
    @GetMapping("/posts/{postId}")
    public ApiResponse<GetPostRes> getPost(@PathVariable Long postId) {
        return ApiResponse.ok(getPostUseCase.getPost(postId));
    }

    // 게시글 등록
    @PostMapping("/posts")
    public ResponseEntity<ApiResponse<String>> createPost(@RequestBody CreatePostReq createPost) {
        ApiResponse<String> response = ApiResponse.ok(createPostUseCase.createPost(createPost));
        return ApiResponse.toResponseEntity(response);
    }
//
//    // 게시글 수정
//    @PatchMapping("/posts/{postId}")
//    public ApiResponse<String> patchPost(@PathVariable Long postId, @RequestBody ModifyPostReq modifyPost) {
//        ApiResponse.ok(patchPostUseCase.patchPost(postId, modifyPost));
//    }
//
//    // 게시글 삭제
//    @DeleteMapping("/posts/{postId}")
//    public ApiResponse<String> deletePost(@PathVariable Long postId) {
//        ApiResponse.ok(deletePostUseCase.deletePost(postId));
//    }
//
//    // 게시글 추천
//    @PatchMapping("/posts/{postId}/likes")
//    public ApiResponse<String> likePost(@PathVariable Long postId) {
//        ApiResponse.ok(likePostUseCase.likePost(postId));
//    }

}
