package com.side_project.daily_assistant.adapter.in.board;

import com.side_project.daily_assistant.application.port.in.board.CreatePostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final CreatePostUseCase createPostUseCase;

    public record CreatePost(
            String title,
            String content,
            String userId
            ) { }

    @PostMapping("/posts")
    public void createPost(@RequestBody PostController.CreatePost createPost) {
        createPostUseCase.createPost(createPost);
    }

//    @GetMapping("/posts")
//    public

//    // 카테고리, 도시에 맞는 전체 게시물 조회
//    @GetMapping("/posts")
//    public ResponseDto<List<PostMainResDto>> getPosts(@RequestParam("postType") String postType, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return ResponseDto.success(postService.getPosts(postType, userDetails.getAccount()));
//    }
//
//    // 게시물 단건조회
//    @GetMapping("/posts/{postId}")
//    public ResponseDto<PostDetailResDto> getPost(@PathVariable Long postId) {
//        return ResponseDto.success(postService.getPost(postId));
//    }
}
