package com.side_project.daily_assistant.adapter.member.out;

import com.side_project.daily_assistant.application.port.member.out.RegisterMemberPort;
import com.side_project.daily_assistant.dto.requestdto.member.RegisterMemberReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterMemberPersistenceAdapter implements RegisterMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public String registerMember(RegisterMemberReq registerMember) {
        MemberEntity memberEntity = MemberEntity.create(registerMember);
        memberRepository.save(memberEntity);
        return "계정 등록에 성공하였습니다";
    }
}
