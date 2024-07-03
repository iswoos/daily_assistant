package com.side_project.daily_assistant.adapter.out.member;

import com.side_project.daily_assistant.domain.member.Member;
import com.side_project.daily_assistant.dto.requestdto.member.RegisterMemberReq;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member toDomain(MemberEntity memberEntity);

    MemberEntity toEntity(Member domain);

    MemberEntity toEntity(RegisterMemberReq registerMember);

}
