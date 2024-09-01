package com.side_project.daily_assistant.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 400 Bad Request 요청데이터 옳지않음
    BAD_REQUEST_PARAMETER(400, HttpStatus.BAD_REQUEST, "옳지않은 파라미터입니다."),
    PARENT_COMMENT_MISMATCH(400, HttpStatus.BAD_REQUEST, "부모 댓글과 자식 댓글의 게시글 번호가 일치하지 않습니다."),

    // 404 NOT_FOUND 존재하지 않음
    USER_NOT_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다."),
    POST_NOT_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 게시물입니다."),
    COMMENT_NOT_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 댓글입니다."),

    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러입니다.");

    private final int status;
    private final HttpStatus httpStatus;
    private final String message;
}
