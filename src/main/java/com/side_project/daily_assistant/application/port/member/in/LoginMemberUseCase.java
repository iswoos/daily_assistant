package com.side_project.daily_assistant.application.port.member.in;

import com.side_project.daily_assistant.dto.requestdto.member.LoginMemberReq;

public interface LoginMemberUseCase {
    String loginMember(LoginMemberReq loginMember);
}
