package org.ikonnikau.aoppractice.util;

import lombok.Data;

import java.util.Collection;

@Data
public class CustomResponse<T> {
    private int code;
    private String message;
    private Collection<T> response;

    public CustomResponse(Collection<T> response, CustomStatus status) {
        this.response = response;
        this.code = status.getCode();
        this.message = status.getMessage();
    }
}
