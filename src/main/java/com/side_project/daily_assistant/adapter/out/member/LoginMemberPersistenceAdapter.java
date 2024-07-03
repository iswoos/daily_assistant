package com.side_project.daily_assistant.adapter.out.member;

import com.side_project.daily_assistant.application.port.out.member.LoginMemberPort;
import com.side_project.daily_assistant.dto.requestdto.member.LoginMemberReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginMemberPersistenceAdapter implements LoginMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public void loginMember(LoginMemberReq loginMember) {
        memberRepository.findByUserId(loginMember.userId()).orElseThrow(
                () -> new IllegalArgumentException("로그인이 실패하였습니다")
        );
    }
}
