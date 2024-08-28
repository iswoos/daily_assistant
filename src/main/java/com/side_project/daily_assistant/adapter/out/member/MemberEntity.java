package com.side_project.daily_assistant.adapter.out.member;

import com.side_project.daily_assistant.adapter.out.board.PostEntity;
import com.side_project.daily_assistant.adapter.out.common.isDeleted;
import com.side_project.daily_assistant.domain.BaseEntity;
import com.side_project.daily_assistant.dto.requestdto.board.CreatePostReq;
import com.side_project.daily_assistant.dto.requestdto.member.RegisterMemberReq;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "member")
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String userId;

    private String password;

    private Double latitude;

    private Double longitude;

    private LocalDateTime createdDateTime;

    private LocalDateTime modifiedDateTime;

    @Builder
    private MemberEntity(
            Long id,
            String userId,
            String password,
            Double latitude,
            Double longitude,
            LocalDateTime createdDateTime,
            LocalDateTime modifiedDateTime) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }

    public static MemberEntity create(RegisterMemberReq registerMemberReq) {
        return MemberEntity.builder()
                .userId(registerMemberReq.userId())
                .password(registerMemberReq.password())
                .latitude(Double.valueOf(0))
                .longitude(Double.valueOf(0))
                .createdDateTime(LocalDateTime.now())
                .modifiedDateTime(LocalDateTime.now())
                .build();
    }

}

