package com.side_project.daily_assistant.adapter.member.in;

import com.side_project.daily_assistant.application.port.member.in.LoginMemberUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.requestdto.member.LoginMemberReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginMemberController {

    private final LoginMemberUseCase loginMemberUseCase;

    // 로그인
    @PostMapping("/members/login")
    public ResponseEntity<ApiResponse<String>> loginMember(@RequestBody LoginMemberReq loginMember) {
        ApiResponse<String> response = ApiResponse.ok(loginMemberUseCase.loginMember(loginMember));
        return ApiResponse.toResponseEntity(response);
    }
}
