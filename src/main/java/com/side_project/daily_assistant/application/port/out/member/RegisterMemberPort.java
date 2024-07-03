package com.side_project.daily_assistant.application.port.out.member;

import com.side_project.daily_assistant.dto.requestdto.member.RegisterMemberReq;

public interface RegisterMemberPort {
    void registerMember(RegisterMemberReq registerMember);
}
