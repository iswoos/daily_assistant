package com.side_project.daily_assistant.application.port.member.out;

import com.side_project.daily_assistant.dto.requestdto.member.LoginMemberReq;

public interface LoginMemberPort {
    String loginMember(LoginMemberReq loginMember);
}
