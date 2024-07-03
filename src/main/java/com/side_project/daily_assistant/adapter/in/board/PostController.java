package com.side_project.daily_assistant.adapter.in.board;

import com.side_project.daily_assistant.application.port.in.board.CreatePostUseCase;
import com.side_project.daily_assistant.application.port.in.board.GetPostUseCase;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.responsedto.board.GetPostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final CreatePostUseCase createPostUseCase;
    private final GetPostUseCase getPostUseCase;

    // 게시글 등록
    @PostMapping("/posts")
    public void createPost(@RequestBody CreatePostReq createPost) {
        createPostUseCase.createPost(createPost);
    }

    // 게시글 단건조회
    @GetMapping("/posts/{postId}")
    public GetPostRes getPost(@PathVariable Long postId) {
        return getPostUseCase.getPost(postId);
    }

//    // 카테고리, 도시에 맞는 전체 게시물 조회
//    @GetMapping("/posts")
//    public ResponseDto<List<PostMainResDto>> getPosts(@RequestParam("postType") String postType, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return ResponseDto.success(postService.getPosts(postType, userDetails.getAccount()));
//    }
//
}
