package com.side_project.daily_assistant.adapter.out.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum isDeleted {
    Y("삭제"),
    N("미삭제");

    private final String text;
}

