package com.side_project.daily_assistant.application.port.out.member;

import com.side_project.daily_assistant.adapter.in.member.MemberController;
import com.side_project.daily_assistant.domain.member.Member;

public interface LoginMemberPort {
    void loginMember(MemberController.LoginMember loginMember);
}
