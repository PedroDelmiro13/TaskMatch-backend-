package com.taskmatch.taskmatch.Exception;

public class UnauthorizedChatAccessException extends RuntimeException {
    public UnauthorizedChatAccessException(String message) {
        super(message);
    }
}
