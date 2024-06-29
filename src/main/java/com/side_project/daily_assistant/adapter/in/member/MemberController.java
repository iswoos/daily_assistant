package com.side_project.daily_assistant.adapter.in.member;

import com.side_project.daily_assistant.application.port.in.member.LoginMemberUseCase;
import com.side_project.daily_assistant.application.port.in.member.RegisterMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final RegisterMemberUseCase registerMemberUseCase;
    private final LoginMemberUseCase loginMemberUseCase;

    public record RegisterMember(
            String userId,
            String password
    ) {
    }

    public record LoginMember(
            String userId,
            String password
    ) {
    }

    // 회원가입
    @PostMapping("/members/signup")
    public void registerMember(@RequestBody RegisterMember registerMember) {
        registerMemberUseCase.registerMember(registerMember);
    }

    // 로그인
    @PostMapping("/members/login")
    public void loginMember(@RequestBody LoginMember loginMember) {
        loginMemberUseCase.loginMember(loginMember);
    }

    @GetMapping("/members")
    public String asdf() {
        System.out.println("asdf");
        return "asdf";
    }
}
