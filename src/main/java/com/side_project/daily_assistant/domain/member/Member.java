package com.side_project.daily_assistant.domain.member;

import com.side_project.daily_assistant.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String userId;

    private String password;

    private Double latitude;

    private Double longitude;

    public void locationInfoSet(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
