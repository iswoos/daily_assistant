package com.side_project.daily_assistant.adapter.out;

import com.side_project.daily_assistant.adapter.in.MemberAdapter;
import com.side_project.daily_assistant.application.port.out.RegisterMemberPort;
import com.side_project.daily_assistant.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements RegisterMemberPort {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;


    @Override
    public Member registerMember(MemberAdapter.RegisterMember registerMember) {
        MemberEntity memberEntity = memberMapper.toEntity(registerMember);
        memberRepository.save(memberEntity);
        Member member = memberMapper.toDomain(memberEntity);
        return member;
    }
}
