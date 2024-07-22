package com.side_project.daily_assistant.adapter.in.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    // 댓글 작성
    @PostMapping("/comments")
    public void createComments(@RequestBody ) {

    }
    // 댓글 조회
    @GetMapping("/comments")
    public  createComments(@RequestBody ) {

    }

    // 댓글 삭제
    @DeleteMapping("/comments")
    public  createComments(@RequestBody ) {

    }

    // 댓글 수정
    @PatchMapping("/comments")
    public  createComments(@RequestBody ) {

    }
}
