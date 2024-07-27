package com.side_project.daily_assistant.adapter.in.comment;

import com.side_project.daily_assistant.application.port.in.comment.GetCommentListUseCase;
import com.side_project.daily_assistant.dto.responsedto.comment.GetCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final GetCommentListUseCase getCommentListUseCase;

    // 댓글 조회
    @GetMapping("/comments/{postId}")
    public List<GetCommentRes> getCommentList(@PathVariable Long postId) {
        return getCommentListUseCase.getCommentList(postId);
    }

//    // 댓글 작성
//    @PostMapping("/comments")
//    public void createComments(@RequestBody ) {
//
//    }
//
//    // 댓글 삭제
//    @DeleteMapping("/comments")
//    public  createComments(@RequestBody ) {
//
//    }
//
//    // 댓글 수정
//    @PatchMapping("/comments")
//    public  createComments(@RequestBody ) {
//
//    }
}
