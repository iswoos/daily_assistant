package com.side_project.daily_assistant.adapter.out;

import com.side_project.daily_assistant.adapter.in.MemberAdapter;
import com.side_project.daily_assistant.domain.member.Member;

public interface MemberMapper {

    Member toDomain(MemberEntity memberEntity);

    MemberEntity toEntity(Member domain);

    MemberEntity toEntity(MemberAdapter.RegisterMember registerMember);

}
