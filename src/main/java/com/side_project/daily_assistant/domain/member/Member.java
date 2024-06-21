package com.side_project.daily_assistant.domain.member;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {

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
