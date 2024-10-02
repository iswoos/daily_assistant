package com.side_project.daily_assistant.adapter.in.member;

import com.side_project.daily_assistant.application.port.in.member.RegisterMemberUseCase;
import com.side_project.daily_assistant.dto.global.response.ApiResponse;
import com.side_project.daily_assistant.dto.requestdto.member.RegisterMemberReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterMemberController {

    private final RegisterMemberUseCase registerMemberUseCase;

    // 회원가입
    @PostMapping("/members/signup")
    public ResponseEntity<ApiResponse<String>> registerMember(@RequestBody RegisterMemberReq registerMember) {
        ApiResponse<String> response = ApiResponse.ok(registerMemberUseCase.registerMember(registerMember));
        return ApiResponse.toResponseEntity(response);
    }
}
