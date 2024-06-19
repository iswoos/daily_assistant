package com.side_project.daily_assistant.dto.requestdto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberReqDto {

    private String userId;

    private String password;

    public MemberReqDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public void setEncodePwd(String encodePwd) {
        this.password = encodePwd;
    }
}
