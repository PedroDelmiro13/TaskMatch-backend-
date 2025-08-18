package com.taskmatch.taskmatch.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int status;
    private String error;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorResponse(int value, String message) {
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }
}