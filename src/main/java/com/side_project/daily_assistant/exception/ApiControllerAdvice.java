package com.side_project.daily_assistant.exception;

import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public ApiResponse<Object> customException(CustomException e) {
        return ApiResponse.of(
                e.getHttpStatus(),
                e.getMessage(),
                null
        );
    }
}
