package com.side_project.daily_assistant.application.port.in;

import com.side_project.daily_assistant.adapter.in.MemberAdapter;
import com.side_project.daily_assistant.domain.member.Member;

public interface RegisterMemberUseCase {
    Member registerMember(MemberAdapter.RegisterMember registerMember);
}
