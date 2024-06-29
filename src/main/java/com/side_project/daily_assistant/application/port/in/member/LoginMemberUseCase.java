package com.side_project.daily_assistant.application.port.in.member;

import com.side_project.daily_assistant.adapter.in.member.MemberController;
import com.side_project.daily_assistant.domain.member.Member;

public interface LoginMemberUseCase {
    void loginMember(MemberController.LoginMember loginMember);
}
