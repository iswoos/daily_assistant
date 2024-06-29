package com.side_project.daily_assistant.application.port.in.member;

import com.side_project.daily_assistant.adapter.in.member.MemberController;
import org.springframework.stereotype.Service;

@Service
public interface RegisterMemberUseCase {
    void registerMember(MemberController.RegisterMember registerMember);
}
