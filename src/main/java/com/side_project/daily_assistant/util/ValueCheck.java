package com.side_project.daily_assistant.util;

public class ValueCheck {

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
