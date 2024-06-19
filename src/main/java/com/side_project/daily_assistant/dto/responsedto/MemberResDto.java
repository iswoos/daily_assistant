package com.side_project.daily_assistant.dto.responsedto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResDto {

    private String msg;
    private int statusCode;

    public MemberResDto(String msg, int statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }
}
