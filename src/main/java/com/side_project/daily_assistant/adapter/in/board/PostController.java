package com.side_project.daily_assistant.adapter.in.board;

import com.side_project.daily_assistant.application.port.in.board.*;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.requestdto.board.ModifyPostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
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

    //    public ResponseDto<List<PostMainResDto>> getPosts(@RequestParam("postType") String postType, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return ResponseDto.success(postService.getPosts(postType, userDetails.getAccount()));
//    }

    // 게시글 전체조회
    @GetMapping("/posts")
    public List<GetPostRes> getPostList(){
        return getPostListUseCase.getPostList();
    }

    // 게시글 단건조회
    @GetMapping("/posts/{postId}")
    public GetPostRes getPost(@PathVariable Long postId) {
        return getPostUseCase.getPost(postId);
    }

    // 게시글 등록
    @PostMapping("/posts")
    public void createPost(@RequestBody CreatePostReq createPost) {
        createPostUseCase.createPost(createPost);
    }

    // 게시글 수정
    @PatchMapping("/posts/{postId}")
    public void patchPost(@PathVariable Long postId, @RequestBody ModifyPostReq modifyPost) {
        patchPostUseCase.patchPost(postId, modifyPost);
    }

    // 게시글 삭제
    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Long postId) {
        deletePostUseCase.deletePost(postId);
    }

    // 게시글 추천
    @PatchMapping("/posts/{postId}/likes")
    public void likePost(@PathVariable Long postId) {
        likePostUseCase.likePost(postId);
    }

}
