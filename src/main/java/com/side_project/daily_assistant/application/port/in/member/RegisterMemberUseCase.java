package com.side_project.daily_assistant.application.port.in.member;

import com.side_project.daily_assistant.dto.requestdto.member.RegisterMemberReq;
import org.springframework.stereotype.Service;

@Service
public interface RegisterMemberUseCase {
    String registerMember(RegisterMemberReq registerMember);
}
