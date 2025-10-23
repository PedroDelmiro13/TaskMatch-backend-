package com.taskmatch.taskmatch.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChatDTO {
    @NotBlank
    private String userId;
}
