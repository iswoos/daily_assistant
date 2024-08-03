package com.side_project.daily_assistant.service.member;

import com.side_project.daily_assistant.application.port.in.member.LoginMemberUseCase;
import com.side_project.daily_assistant.application.port.out.member.LoginMemberPort;
import com.side_project.daily_assistant.dto.requestdto.member.LoginMemberReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginMemberService implements LoginMemberUseCase {

    private final LoginMemberPort loginMemberPort;

    @Override
    public String loginMember(LoginMemberReq loginMember) {
        return loginMemberPort.loginMember(loginMember);
    }
}
