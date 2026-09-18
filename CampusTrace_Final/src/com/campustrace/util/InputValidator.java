package com.campustrace.util;

public final class InputValidator {
    private InputValidator() { }

    public static boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
