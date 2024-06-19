package com.side_project.daily_assistant.dto.requestdto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginReqDto {

    private String userId;

    private String password;

    public LoginReqDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
