package com.side_project.daily_assistant.adapter.out.member;

import com.side_project.daily_assistant.application.port.out.member.RegisterMemberPort;
import com.side_project.daily_assistant.dto.requestdto.member.RegisterMemberReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterMemberPersistenceAdapter implements RegisterMemberPort {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;


    @Override
    public String registerMember(RegisterMemberReq registerMember) {
        MemberEntity memberEntity = memberMapper.toEntity(registerMember);
        memberRepository.save(memberEntity);
        return "계정 등록에 성공하였습니다";
    }
}
