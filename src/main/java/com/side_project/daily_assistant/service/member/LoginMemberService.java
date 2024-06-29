package com.side_project.daily_assistant.service.member;

import com.side_project.daily_assistant.adapter.in.member.MemberController;
import com.side_project.daily_assistant.application.port.in.member.LoginMemberUseCase;
import com.side_project.daily_assistant.application.port.out.member.LoginMemberPort;
import com.side_project.daily_assistant.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginMemberService implements LoginMemberUseCase {

    private final LoginMemberPort loginMemberPort;

    @Override
    public void loginMember(MemberController.LoginMember loginMember) {
        loginMemberPort.loginMember(loginMember);
    }
}
