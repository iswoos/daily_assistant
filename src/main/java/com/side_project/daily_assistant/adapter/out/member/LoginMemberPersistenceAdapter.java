package com.side_project.daily_assistant.adapter.out.member;

import com.side_project.daily_assistant.application.port.out.member.LoginMemberPort;
import com.side_project.daily_assistant.dto.requestdto.member.LoginMemberReq;
import com.side_project.daily_assistant.exception.CustomException;
import com.side_project.daily_assistant.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginMemberPersistenceAdapter implements LoginMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public String loginMember(LoginMemberReq loginMember) {
        memberRepository.findByUserId(loginMember.userId()).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );
        return "로그인에 성공하였습니다.";
    }
}
