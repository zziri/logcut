package com.zziri.logcut.exception;

import lombok.Getter;

@Getter
public class NotAcceptableCommandException extends RuntimeException {
    private static final String message = "Not acceptable command exception";

    public NotAcceptableCommandException() {
        super(message);
    }
}
