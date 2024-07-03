package com.side_project.daily_assistant.application.port.out.member;

import com.side_project.daily_assistant.dto.requestdto.member.LoginMemberReq;

public interface LoginMemberPort {
    void loginMember(LoginMemberReq loginMember);
}
