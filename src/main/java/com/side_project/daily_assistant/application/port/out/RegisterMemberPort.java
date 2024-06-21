package com.side_project.daily_assistant.application.port.out;

import com.side_project.daily_assistant.adapter.in.MemberAdapter;
import com.side_project.daily_assistant.domain.member.Member;

public interface RegisterMemberPort {
    Member registerMember(MemberAdapter.RegisterMember registerMember);
}
