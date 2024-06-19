package com.side_project.daily_assistant.service;

import com.side_project.daily_assistant.domain.member.Member;
import com.side_project.daily_assistant.dto.requestdto.LoginReqDto;
import com.side_project.daily_assistant.dto.requestdto.MemberReqDto;
import com.side_project.daily_assistant.dto.responsedto.MemberResDto;
import com.side_project.daily_assistant.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
//    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberResDto signup(MemberReqDto memberReqDto) {

//        memberReqDto.setEncodePwd(passwordEncoder.encode(memberReqDto.getPassword()));

        Member member = Member.builder()
                .userId(memberReqDto.getUserId())
                .password(memberReqDto.getPassword())
                .build();

        memberRepository.save(member);
        return new MemberResDto("Success signup", HttpStatus.OK.value());

    }

    public MemberResDto login(LoginReqDto loginReqDto) {

        Optional<Member> byUserId = memberRepository.findByUserId(loginReqDto.getUserId());

        // 암호화된 비밀번호와 같은지 체크하는 로직이 있어야함

        return new MemberResDto("Success Login", HttpStatus.OK.value());
    }
}
