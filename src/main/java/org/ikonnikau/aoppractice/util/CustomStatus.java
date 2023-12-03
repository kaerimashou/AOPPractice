package org.ikonnikau.aoppractice.util;

import lombok.Getter;

@Getter
public enum CustomStatus {
    SUCCESS(0, "SUCCESS"),
    NOT_FOUND(1, "NOT FOUND"),
    EXCEPTION(2, "EXCEPTION");

    private final int code;
    private final String message;

    CustomStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
