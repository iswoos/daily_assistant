package com.side_project.daily_assistant.adapter.out;


import com.side_project.daily_assistant.adapter.out.MemberEntity;
import com.side_project.daily_assistant.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<Member> findByUserId(String userId);

}
