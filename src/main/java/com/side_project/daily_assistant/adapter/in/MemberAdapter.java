package com.side_project.daily_assistant.adapter.in;

import com.side_project.daily_assistant.application.port.in.RegisterMemberUseCase;
import com.side_project.daily_assistant.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberAdapter {

    private final RegisterMemberUseCase registerMemberUseCase;

    public record RegisterMember(
            String userId,
            String password
    ){}

    // 회원가입
    @PostMapping("/members/signup")
    public Member registerMember(@RequestBody RegisterMember registerMember) {
        return registerMemberUseCase.registerMember(registerMember);
    }
}
