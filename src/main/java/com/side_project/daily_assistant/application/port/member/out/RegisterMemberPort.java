package com.side_project.daily_assistant.application.port.member.out;

import com.side_project.daily_assistant.dto.requestdto.member.RegisterMemberReq;

public interface RegisterMemberPort {
    String registerMember(RegisterMemberReq registerMember);
}
