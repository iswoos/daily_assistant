package com.side_project.daily_assistant.adapter.out.member;

import com.side_project.daily_assistant.adapter.in.member.MemberController;
import com.side_project.daily_assistant.domain.member.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member toDomain(MemberEntity memberEntity);

    MemberEntity toEntity(Member domain);

    MemberEntity toEntity(MemberController.RegisterMember registerMember);

}
