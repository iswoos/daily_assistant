package com.side_project.daily_assistant.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class CustomException extends RuntimeException{

    private final int status;
    private final HttpStatus httpStatus;

    public CustomException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.status = errorCode.getStatus();
        this.httpStatus = errorCode.getHttpStatus();
    }
}
